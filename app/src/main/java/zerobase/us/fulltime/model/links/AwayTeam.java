package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the link for the away team.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class AwayTeam implements Parcelable {

    @SerializedName("href")
    private String href;

    protected AwayTeam(Parcel in) {
        href = in.readString();
    }

    public static final Creator<AwayTeam> CREATOR = new Creator<AwayTeam>() {
        @Override
        public AwayTeam createFromParcel(Parcel in) {
            return new AwayTeam(in);
        }

        @Override
        public AwayTeam[] newArray(int size) {
            return new AwayTeam[size];
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
