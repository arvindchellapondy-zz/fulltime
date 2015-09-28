package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the team's table standings.
 * Created by Sripadmanaban on 9/28/2015.
 */
public class Standing implements Parcelable {

    @SerializedName("_links")
    private Links links;

    @SerializedName("position")
    private long position;

    @SerializedName("teamName")
    private String teamName;

    @SerializedName("playedGames")
    private long playedGames;

    @SerializedName("points")
    private long points;

    @SerializedName("goals")
    private long goals;

    @SerializedName("goalsAgainst")
    private long goalsAgainst;

    @SerializedName("goalDifference")
    private long goalDifference;

    protected Standing(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        position = in.readLong();
        teamName = in.readString();
        playedGames = in.readLong();
        points = in.readLong();
        goals = in.readLong();
        goalsAgainst = in.readLong();
        goalDifference = in.readLong();
    }

    public static final Creator<Standing> CREATOR = new Creator<Standing>() {
        @Override
        public Standing createFromParcel(Parcel in) {
            return new Standing(in);
        }

        @Override
        public Standing[] newArray(int size) {
            return new Standing[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(links, flags);
        dest.writeLong(position);
        dest.writeString(teamName);
        dest.writeLong(playedGames);
        dest.writeLong(points);
        dest.writeLong(goals);
        dest.writeLong(goalsAgainst);
        dest.writeLong(goalDifference);
    }
}
