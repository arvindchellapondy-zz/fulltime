package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the link to the soccer season.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class SoccerSeason implements Parcelable {

    @SerializedName("href")
    private String href;

    protected SoccerSeason(Parcel in) {
        href = in.readString();
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
        dest.writeString(href);
    }
}
