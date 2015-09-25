package zerobase.us.fulltime.model.links;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that holds the link to itself.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Self implements Parcelable {

    @SerializedName("href")
    private String href;

    protected Self(Parcel in) {
        href = in.readString();
    }

    public static final Creator<Self> CREATOR = new Creator<Self>() {
        @Override
        public Self createFromParcel(Parcel in) {
            return new Self(in);
        }

        @Override
        public Self[] newArray(int size) {
            return new Self[size];
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
