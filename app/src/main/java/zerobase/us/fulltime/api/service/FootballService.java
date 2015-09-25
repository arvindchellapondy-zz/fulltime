package zerobase.us.fulltime.api.service;

import android.app.Application;

import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;

import zerobase.us.fulltime.base.interceptor.SpiceRequestInterceptor;
import zerobase.us.fulltime.base.service.BaseSpiceService;
import zerobase.us.fulltime.interfaces.api.FootballRequestManager;
import zerobase.us.fulltime.utils.FootballURL;

/**
 * This is the class that is the service on which the calls will be made on.
 * Created by Sripadmanaban on 9/25/2015.
 */
public class FootballService extends BaseSpiceService<FootballRequestManager> {

    CacheManager retrofitCacheManager;

    @Override
    public void onCreate() {
        requestInterceptor = new SpiceRequestInterceptor(getApplicationContext());
        retrofitCacheManager = new CacheManager();
        super.onCreate();
        addRequestManger(FootballRequestManager.class);
    }

    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        return retrofitCacheManager;
    }

    @Override
    protected String getServerURL() {
        return FootballURL.getBaseURL();
    }
}
