package zerobase.us.fulltime.model.fixture;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains details about the result of a fixture.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Result implements Parcelable {

    @SerializedName("goalsHomeTeam")
    private int goalsHomeTeam;

    @SerializedName("goalsAwayTeam")
    private int goalsAwayTeam;

    protected Result(Parcel in) {
        goalsHomeTeam = in.readInt();
        goalsAwayTeam = in.readInt();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(goalsHomeTeam);
        dest.writeInt(goalsAwayTeam);
    }
}
