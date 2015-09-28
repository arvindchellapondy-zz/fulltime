package zerobase.us.fulltime.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import zerobase.us.fulltime.model.Fixture;

/**
 * This is the class that holds the response for the fixtures call.
 * Created by Sripadmanaban on 9/28/2015.
 */
public class FixturesResponse implements Parcelable {

    @SerializedName("count")
    private long count;

    @SerializedName("fixtures")
    private ArrayList<Fixture> fixtures;

    protected FixturesResponse(Parcel in) {
        count = in.readLong();
        fixtures = in.createTypedArrayList(Fixture.CREATOR);
    }

    public static final Creator<FixturesResponse> CREATOR = new Creator<FixturesResponse>() {
        @Override
        public FixturesResponse createFromParcel(Parcel in) {
            return new FixturesResponse(in);
        }

        @Override
        public FixturesResponse[] newArray(int size) {
            return new FixturesResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(count);
        dest.writeTypedList(fixtures);
    }
}
