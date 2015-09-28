package zerobase.us.fulltime.api.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import zerobase.us.fulltime.model.Links;
import zerobase.us.fulltime.model.Player;

/**
 * This is the class that will hold the response for the players request.
 * Created by Sripadmanaban on 9/28/2015.
 */
public class PlayerResponse implements Parcelable {

    @SerializedName("_links")
    Links links;

    @SerializedName("count")
    long count;

    @SerializedName("players")
    ArrayList<Player> players;

    protected PlayerResponse(Parcel in) {
        links = in.readParcelable(Links.class.getClassLoader());
        count = in.readLong();
        players = in.createTypedArrayList(Player.CREATOR);
    }

    public static final Creator<PlayerResponse> CREATOR = new Creator<PlayerResponse>() {
        @Override
        public PlayerResponse createFromParcel(Parcel in) {
            return new PlayerResponse(in);
        }

        @Override
        public PlayerResponse[] newArray(int size) {
            return new PlayerResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(links, flags);
        dest.writeLong(count);
        dest.writeTypedList(players);
    }
}
