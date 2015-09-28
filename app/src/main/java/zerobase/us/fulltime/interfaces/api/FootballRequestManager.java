package zerobase.us.fulltime.interfaces.api;

import retrofit.http.GET;
import retrofit.http.Path;
import zerobase.us.fulltime.api.response.FixturesResponse;
import zerobase.us.fulltime.api.response.LeagueTableResponse;
import zerobase.us.fulltime.api.response.PlayerResponse;
import zerobase.us.fulltime.api.response.TeamsResponse;
import zerobase.us.fulltime.model.SoccerSeason;
import zerobase.us.fulltime.model.Team;

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
     * @param seasonID A long that holds the seasons ID.
     * @return An object of SoccerSeason.
     */
    @GET("/alpha/soccerseasons/{seasonID}")
    SoccerSeason getSeasonBySeasonID(
            @Path("seasonID") long seasonID);

    /**
     * This is the function that is to be called to get the teams in a particular season.
     *
     * @param seasonID A long that holds the season ID who's teams are required.
     * @return An object of TeamsResponse.
     */
    @GET("/alpha/soccerseasons/{seasonID}/teams")
    TeamsResponse getTeamsBySeasonID(
            @Path("seasonID") long seasonID);

    /**
     * This is the function that is to be called to get the team by a team ID.
     *
     * @param teamID A long that holds the team ID.
     * @return An object of Team.
     */
    @GET("alpha/teams/{teamID}")
    Team getTeamByTeamID(
            @Path("teamID") long teamID);

    /**
     * This is the function that is called to get the players in a team.
     *
     * @param teamID A long that contains the teams ID.
     * @return An object of PlayerResponse.
     */
    @GET("/alpha/teams/{teamID}/players")
    PlayerResponse getPlayerByTeamID(
            @Path("teamID") long teamID);

    /**
     * This is the function to call to get the league table for a season.
     *
     * @param seasonID A long that contains the seasons id.
     * @return An object of LeagueTableResponse.
     */
    @GET("/alpha/soccerseasons/{seasonID}/leagueTable")
    LeagueTableResponse getLeagueTableBySeasonID(
            @Path("seasonID") long seasonID);

    /**
     * This is the function to be called to get the fixtures for a season.
     *
     * @param seasonID A long that contains the season id.
     * @return An object of FixturesResponse.
     */
    @GET("/alpha/soccerseasons/{seasonID}/fixtures")
    FixturesResponse getFixturesForSeason(
            @Path("seasonID") long seasonID);

    /**
     * This is the function to be called to get the fixtures for a team.
     *
     * @param teamID A long that contains the team id.
     * @return An object of FixturesResponse.
     */
    @GET("/alpha/teams/{teamID}/fixtures")
    FixturesResponse getFixturesForTeam(
            @Path("teamID") long teamID);

}
