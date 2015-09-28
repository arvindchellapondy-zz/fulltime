package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains all the information about a player.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Player implements Parcelable {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("position")
    private String position;

    @SerializedName("jerseyNumber")
    private int jerseyNumber;

    @SerializedName("dateOfBirth")
    private String dateOfBirth;

    @SerializedName("nationality")
    private String nationality;

    @SerializedName("contractUntil")
    private String contractUntil;

    @SerializedName("marketValue")
    private String marketValue;

    protected Player(Parcel in) {
        id = in.readLong();
        name = in.readString();
        position = in.readString();
        jerseyNumber = in.readInt();
        dateOfBirth = in.readString();
        nationality = in.readString();
        contractUntil = in.readString();
        marketValue = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(position);
        dest.writeInt(jerseyNumber);
        dest.writeString(dateOfBirth);
        dest.writeString(nationality);
        dest.writeString(contractUntil);
        dest.writeString(marketValue);
    }
}
