package zerobase.us.fulltime.base.interceptor;

import android.content.Context;

import retrofit.RequestInterceptor;
import zerobase.us.fulltime.R;

/**
 * This is the class that is used to intercept the request and add necessary headers.
 * Created by Sripadmanaban on 9/16/2015.
 */
public class SpiceRequestInterceptor implements RequestInterceptor {

    private String apiKey;

    public SpiceRequestInterceptor(Context context) {
        apiKey = context.getString(R.string.api_key);
        if(apiKey.equals("api_key")) {
            apiKey = "";
        }
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader("X-Auth-Token", apiKey);
    }
}
