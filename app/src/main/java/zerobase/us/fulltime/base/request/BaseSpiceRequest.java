package zerobase.us.fulltime.base.request;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import zerobase.us.fulltime.interfaces.cache.CacheableSpiceRequest;

/**
 * This is the base for the spice request that will be extended for the request.
 * Created by Sripadmanaban on 9/16/2015.
 */
public abstract class BaseSpiceRequest<T, V> extends RetrofitSpiceRequest<T, V>
        implements CacheableSpiceRequest {

    public BaseSpiceRequest(Class<T> clazz, Class<V> retrofitedInterfaceClass) {
        super(clazz, retrofitedInterfaceClass);
    }
}
