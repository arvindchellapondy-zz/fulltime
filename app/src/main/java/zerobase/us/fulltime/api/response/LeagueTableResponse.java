package zerobase.us.fulltime.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import zerobase.us.fulltime.model.Links;
import zerobase.us.fulltime.model.Standing;

/**
 * This is the response that holds the whole league table.
 * Created by Sripadmanaban on 9/28/2015.
 */
public class LeagueTableResponse implements Parcelable {

    @SerializedName("_links")
    private Links links;

    @SerializedName("leagueCaption")
    private String leagueCaption;

    @SerializedName("matchday")
    private Long matchDay;

    @SerializedName("standing")
    private ArrayList<Standing> standings;

    protected LeagueTableResponse(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        leagueCaption = in.readString();
        standings = in.createTypedArrayList(Standing.CREATOR);
    }

    public static final Creator<LeagueTableResponse> CREATOR = new Creator<LeagueTableResponse>() {
        @Override
        public LeagueTableResponse createFromParcel(Parcel in) {
            return new LeagueTableResponse(in);
        }

        @Override
        public LeagueTableResponse[] newArray(int size) {
            return new LeagueTableResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(links, flags);
        dest.writeString(leagueCaption);
        dest.writeTypedList(standings);
    }
}
