package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class Links implements Parcelable {

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

    protected Links(Parcel in) {
        self = in.readParcelable(Self.class.getClassLoader());
        awayTeam = in.readParcelable(AwayTeam.class.getClassLoader());
        fixtures = in.readParcelable(Fixtures.class.getClassLoader());
        homeTeam = in.readParcelable(HomeTeam.class.getClassLoader());
        leagueTable = in.readParcelable(LeagueTable.class.getClassLoader());
        players = in.readParcelable(Players.class.getClassLoader());
        soccerSeason = in.readParcelable(SoccerSeason.class.getClassLoader());
        teams = in.readParcelable(Teams.class.getClassLoader());
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(self, flags);
        dest.writeParcelable(awayTeam, flags);
        dest.writeParcelable(fixtures, flags);
        dest.writeParcelable(homeTeam, flags);
        dest.writeParcelable(leagueTable, flags);
        dest.writeParcelable(players, flags);
        dest.writeParcelable(soccerSeason, flags);
        dest.writeParcelable(teams, flags);
    }
}
