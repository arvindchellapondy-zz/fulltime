package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the link for the fixtures.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Fixtures implements Parcelable {

    @SerializedName("href")
    private String href;

    protected Fixtures(Parcel in) {
        href = in.readString();
    }

    public static final Creator<Fixtures> CREATOR = new Creator<Fixtures>() {
        @Override
        public Fixtures createFromParcel(Parcel in) {
            return new Fixtures(in);
        }

        @Override
        public Fixtures[] newArray(int size) {
            return new Fixtures[size];
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
