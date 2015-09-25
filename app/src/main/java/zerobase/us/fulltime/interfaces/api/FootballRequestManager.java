package zerobase.us.fulltime.interfaces.api;

import retrofit.http.GET;
import retrofit.http.Path;
import zerobase.us.fulltime.model.SoccerSeason;
import zerobase.us.fulltime.model.Teams;

/**
 * This is the interface that will be used to take care of the api calls.
 * Created by Sripadmanaban on 9/24/2015.
 */
public interface FootballRequestManager {

    /**
     * This is the function that is to be called to get all the seasons.
     *
     * @return An array of SoccerSeason.
     */
    @GET("/alpha/soccerseasons")
    SoccerSeason[] getSeasons();

    /**
     * This is the function that is to be called to retrieve one season by ID.
     *
     * @param seasonID An integer that holds the seasons ID.
     * @return An object of SoccerSeason.
     */
    @GET("/alpha/soccerseasons/{seasonID")
    SoccerSeason getSeasonByID(
            @Path("seasonID") int seasonID);

}
