package zerobase.us.fulltime.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import zerobase.us.fulltime.model.SoccerSeason;

/**
 * This is the class that will hold the response for the seasons request.
 * Created by Sripadmanaban on 9/24/2015.
 */
public class SoccerSeasonsResponse implements Parcelable {

    private ArrayList<SoccerSeason> soccerSeasons;

    protected SoccerSeasonsResponse(Parcel in) {
        soccerSeasons = in.createTypedArrayList(SoccerSeason.CREATOR);
    }

    public static final Creator<SoccerSeasonsResponse> CREATOR = new Creator<SoccerSeasonsResponse>() {
        @Override
        public SoccerSeasonsResponse createFromParcel(Parcel in) {
            return new SoccerSeasonsResponse(in);
        }

        @Override
        public SoccerSeasonsResponse[] newArray(int size) {
            return new SoccerSeasonsResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(soccerSeasons);
    }
}
