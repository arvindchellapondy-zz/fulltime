package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the details about the team.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Teams implements Parcelable {

    @SerializedName("_links")
    Links links;

    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("squadMarketValue")
    private String squadMarketValue;

    @SerializedName("crestUrl")
    private String crestURL;

    protected Teams(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        name = in.readString();
        code = in.readString();
        shortName = in.readString();
        squadMarketValue = in.readString();
        crestURL = in.readString();
    }

    public static final Creator<Teams> CREATOR = new Creator<Teams>() {
        @Override
        public Teams createFromParcel(Parcel in) {
            return new Teams(in);
        }

        @Override
        public Teams[] newArray(int size) {
            return new Teams[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(links, flags);
        dest.writeString(name);
        dest.writeString(code);
        dest.writeString(shortName);
        dest.writeString(squadMarketValue);
        dest.writeString(crestURL);
    }
}
