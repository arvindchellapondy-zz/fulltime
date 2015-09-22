package zerobase.us.fulltime.utils;

import zerobase.us.fulltime.BuildConfig;

/**
 * This is the class that holds the URL to be called.
 * Created by Sripadmanaban on 9/15/2015.
 */
public class FootballURL {

    private static String baseURL;

    public static String getBaseURL() {
        if(BuildConfig.BUILD_TYPE.matches("debug")) {
            baseURL = "http://api.football-data.org";
        } else {
            baseURL = "";
        }
        return null;
    }

}
