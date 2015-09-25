package zerobase.us.fulltime.interfaces.api;

import retrofit.http.GET;
import zerobase.us.fulltime.model.SoccerSeason;

/**
 * This is the interface that will be used to take care of the api calls.
 * Created by Sripadmanaban on 9/24/2015.
 */
public interface FootballRequestManager {

    /**
     * This is the function that is to be called to get all the seasons.
     *
     * @return An Object of SoccerSeasonsResponse.
     */
    @GET("/alpha/soccerseasons")
    public SoccerSeason[] getSeasons();

}
