package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the link to the players.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Players implements Parcelable {

    @SerializedName("href")
    private String href;

    protected Players(Parcel in) {
        href = in.readString();
    }

    public static final Creator<Players> CREATOR = new Creator<Players>() {
        @Override
        public Players createFromParcel(Parcel in) {
            return new Players(in);
        }

        @Override
        public Players[] newArray(int size) {
            return new Players[size];
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
