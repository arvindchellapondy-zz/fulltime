package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the details about the team.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Team implements Parcelable {

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

    protected Team(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        name = in.readString();
        code = in.readString();
        shortName = in.readString();
        squadMarketValue = in.readString();
        crestURL = in.readString();
    }

    public static final Creator<Team> CREATOR = new Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel in) {
            return new Team(in);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
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
