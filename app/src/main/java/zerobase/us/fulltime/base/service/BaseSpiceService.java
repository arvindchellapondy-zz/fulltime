package zerobase.us.fulltime.base.service;

import android.app.Application;
import android.app.Notification;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;
import com.octo.android.robospice.persistence.retrofit.RetrofitObjectPersisterFactory;
import com.octo.android.robospice.request.CachedSpiceRequest;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit.RestAdapter;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;
import zerobase.us.fulltime.BuildConfig;
import zerobase.us.fulltime.base.interceptor.SpiceRequestInterceptor;
import zerobase.us.fulltime.utils.FootballURL;

/**
 * This is the class that is used to serve as the base for the request services.
 * Created by Sripadmanaban on 9/16/2015.
 */
public class BaseSpiceService<T> extends SpiceService {

    // This is used to create the service.
    protected RestAdapter restAdapter;

    // Used to create the rest adapter.
    protected RestAdapter.Builder builder;

    // This is the used to for GSON conversion.
    protected Converter converter = null;

    // As the name states it links the request manager to the service.
    private Map<Class<?>, Object> requestManagerToServiceMap = new HashMap<>();

    // This is the list of request managers.
    protected List<Class<?>> requestManagerList = new ArrayList<>();

    // This is the object for the request interceptor.
    protected SpiceRequestInterceptor requestInterceptor;

    // Used to set the error handler in the rest adapter.
    protected ErrorHandler networkErrorHandler = new ErrorHandler() {
        @Override
        public Throwable handleError(RetrofitError cause) {
            return cause;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        builder = (builder != null) ? builder : createRestAdapterBuilder();
    }

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager cacheManager = new CacheManager();
        cacheManager.addPersister(new RetrofitObjectPersisterFactory(application, converter));

        return cacheManager;
    }

    @Override
    public Notification createDefaultNotification() {
        // We return null so that it does not start the service in foreground.
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addRequest(CachedSpiceRequest<?> request, Set<RequestListener<?>> listRequestListener) {
        if(request.getSpiceRequest() instanceof RetrofitSpiceRequest) {
            RetrofitSpiceRequest retrofitSpiceRequest =
                    (RetrofitSpiceRequest) request.getSpiceRequest();

            retrofitSpiceRequest.setService(getRetofitService(retrofitSpiceRequest
                    .getRetrofitedInterfaceClass()));
        }

        super.addRequest(request, listRequestListener);
    }

    /**
     * This is the function that is used to create the rest adapter builder.
     * @return An object of RestAdapter.Builder used to create the rest adapter.
     */
    private RestAdapter.Builder createRestAdapterBuilder() {
        builder = new RestAdapter.Builder();
        builder.setEndpoint(getServerURL());

        if(converter != null) {
            builder.setConverter(converter);
        } else {
            Gson customGSONWithExclude = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    // If there is something that needs to be skipped then add it here like this
                    // f.getDeclaredClass().equals("Your class name".class)
                    return false;
                }

                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }
            }).create();

            converter = new GsonConverter(customGSONWithExclude);
            builder.setConverter(converter);
        }

        if(requestInterceptor != null) {
            builder.setRequestInterceptor(requestInterceptor);
            builder.setErrorHandler(networkErrorHandler);
        }

        if(BuildConfig.BUILD_TYPE.matches("debug") || BuildConfig.BUILD_TYPE.matches("beta")) {
            builder.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        Client client = new OkClient();
        builder.setClient(client);

        return builder;
    }

    /**
     * This is the function that is used to get the server endpoint.
     * @return A String that contains the servers URL.
     */
    private String getServerURL() {
        return FootballURL.getBaseURL();
    }

    /**
     * This is the function that is used to add a request manager for a particular service.
     * @param requestManager A request manager object, who's calls will be taken care of by the
     *                       service that calls this function.
     */
    protected void addRequestManger(Class<?> requestManager) {
        requestManagerList.add(requestManager);
    }

    /**
     * This is the function that is used to get the service class that is related to the request
     * manager.
     * @param requestManager A request manager class who's service is required.
     * @param <T> Not exactly provided. Not sure.
     * @return An object that represents the service that is related to the request manager.
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected <T> T getRetofitService(Class<T> requestManager) {
        T service = (T) requestManagerToServiceMap.get(requestManager);

        if(service == null) {
            // Creating a service for the request manager.
            service = restAdapter.create(requestManager);
            requestManagerToServiceMap.put(requestManager, service);
        }

        return service;
    }

    /**
     * This is a function that returns all the request manager classes.
     * @return A list of class. The classes are request managers.
     */
    public List<Class<?>> getRequestManagerList() {
        return requestManagerList;
    }
}
