package zerobase.us.fulltime.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import zerobase.us.fulltime.model.Team;

/**
 * This is the response that holds all the teams.
 * Created by Sripadmanaban on 9/25/2015.
 */
public class TeamsResponse implements Parcelable {

    @SerializedName("count")
    private long count;

    @SerializedName("teams")
    private ArrayList<Team> teams;

    protected TeamsResponse(Parcel in) {
        count = in.readLong();
        teams = in.createTypedArrayList(Team.CREATOR);
    }

    public static final Creator<TeamsResponse> CREATOR = new Creator<TeamsResponse>() {
        @Override
        public TeamsResponse createFromParcel(Parcel in) {
            return new TeamsResponse(in);
        }

        @Override
        public TeamsResponse[] newArray(int size) {
            return new TeamsResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(count);
        dest.writeTypedList(teams);
    }
}
