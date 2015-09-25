package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the link to the home team.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class HomeTeam implements Parcelable {

    @SerializedName("href")
    private String href;

    protected HomeTeam(Parcel in) {
        href = in.readString();
    }

    public static final Creator<HomeTeam> CREATOR = new Creator<HomeTeam>() {
        @Override
        public HomeTeam createFromParcel(Parcel in) {
            return new HomeTeam(in);
        }

        @Override
        public HomeTeam[] newArray(int size) {
            return new HomeTeam[size];
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
