package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the details about the season.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class SoccerSeason implements Parcelable {

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

    protected SoccerSeason(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        caption = in.readString();
        league = in.readString();
        year = in.readString();
        numberOfTeams = in.readInt();
        numberOfGames = in.readInt();
        lastUpdated = in.readString();
    }

    public static final Creator<SoccerSeason> CREATOR = new Creator<SoccerSeason>() {
        @Override
        public SoccerSeason createFromParcel(Parcel in) {
            return new SoccerSeason(in);
        }

        @Override
        public SoccerSeason[] newArray(int size) {
            return new SoccerSeason[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(links, flags);
        dest.writeString(caption);
        dest.writeString(league);
        dest.writeString(year);
        dest.writeInt(numberOfTeams);
        dest.writeInt(numberOfGames);
        dest.writeString(lastUpdated);
    }
}
