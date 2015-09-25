package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import zerobase.us.fulltime.model.fixture.Result;

/**
 * This class contains the details about a fixture.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Fixture implements Parcelable {

    @SerializedName("_links")
    Links links;

    @SerializedName("date")
    private String date;

    @SerializedName("status")
    private String status;

    @SerializedName("matchDay")
    private int matchDay;

    @SerializedName("homeTeamName")
    private String homeTeamName;

    @SerializedName("awayTeamName")
    private String awayTeamName;

    @SerializedName("result")
    Result result;

    protected Fixture(Parcel in) {
        date = in.readString();
        status = in.readString();
        matchDay = in.readInt();
        homeTeamName = in.readString();
        awayTeamName = in.readString();
        result = in.readParcelable(Result.class.getClassLoader());
    }

    public static final Creator<Fixture> CREATOR = new Creator<Fixture>() {
        @Override
        public Fixture createFromParcel(Parcel in) {
            return new Fixture(in);
        }

        @Override
        public Fixture[] newArray(int size) {
            return new Fixture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(date);
        dest.writeString(status);
        dest.writeInt(matchDay);
        dest.writeString(homeTeamName);
        dest.writeString(awayTeamName);
        dest.writeParcelable(result, flags);
    }
}
