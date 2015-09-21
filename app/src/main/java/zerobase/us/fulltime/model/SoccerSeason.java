package zerobase.us.fulltime.model;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the details about the season.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class SoccerSeason {

    @SerializedName("_links")
    Links links;

    @SerializedName("caption")
    private String caption;

    @SerializedName("league")
    private String league;

    @SerializedName("year")
    private String year;

    @SerializedName("numberOfTeams")
    private int numberOfTeams;

    @SerializedName("numberOfGames")
    private int numberOfGames;

    @SerializedName("lastUpdated")
    private String lastUpdated;

}
