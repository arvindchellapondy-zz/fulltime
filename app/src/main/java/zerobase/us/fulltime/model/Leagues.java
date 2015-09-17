package zerobase.us.fulltime.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by arvindchellapondy on 9/14/15.
 */
public class Leagues implements Parcelable {
    private int leagueId;
    private String leagueName;
    private int leagueLogo;

    public Leagues(int id, String name,int logo){
        this.leagueId = id;
        this.leagueName = name;
        this.leagueLogo=logo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.leagueId);
        dest.writeString(this.leagueName);
        dest.writeInt(this.leagueLogo);
    }

    public Leagues() {
    }

    protected Leagues(Parcel in) {
        this.leagueId = in.readInt();
        this.leagueName = in.readString();
        this.leagueLogo = in.readInt();
    }

    public static final Parcelable.Creator<Leagues> CREATOR = new Parcelable.Creator<Leagues>() {
        public Leagues createFromParcel(Parcel source) {
            return new Leagues(source);
        }

        public Leagues[] newArray(int size) {
            return new Leagues[size];
        }
    };

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getLeagueLogo() {
        return leagueLogo;
    }
}
