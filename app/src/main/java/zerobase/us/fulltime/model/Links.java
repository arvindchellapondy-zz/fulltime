package zerobase.us.fulltime.model;

import com.google.gson.annotations.SerializedName;

import zerobase.us.fulltime.model.links.AwayTeam;
import zerobase.us.fulltime.model.links.Fixtures;
import zerobase.us.fulltime.model.links.HomeTeam;
import zerobase.us.fulltime.model.links.LeagueTable;
import zerobase.us.fulltime.model.links.Players;
import zerobase.us.fulltime.model.links.Self;
import zerobase.us.fulltime.model.links.SoccerSeason;
import zerobase.us.fulltime.model.links.Teams;

/**
 * This is the master class that contains the classes in the links folder.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Links {

    @SerializedName("self")
    Self self;

    @SerializedName("awayTeam")
    AwayTeam awayTeam;

    @SerializedName("fixtures")
    Fixtures fixtures;

    @SerializedName("homeTeam")
    HomeTeam homeTeam;

    @SerializedName("leagueTable")
    LeagueTable leagueTable;

    @SerializedName("players")
    Players players;

    @SerializedName("soccerseason")
    SoccerSeason soccerSeason;

    @SerializedName("teams")
    Teams teams;

}
