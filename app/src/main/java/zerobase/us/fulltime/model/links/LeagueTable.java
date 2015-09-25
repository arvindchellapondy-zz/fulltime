package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the link to the league table.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class LeagueTable implements Parcelable {

    @SerializedName("href")
    private String href;

    protected LeagueTable(Parcel in) {
        href = in.readString();
    }

    public static final Creator<LeagueTable> CREATOR = new Creator<LeagueTable>() {
        @Override
        public LeagueTable createFromParcel(Parcel in) {
            return new LeagueTable(in);
        }

        @Override
        public LeagueTable[] newArray(int size) {
            return new LeagueTable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(href);
    }
}
