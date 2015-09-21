package zerobase.us.fulltime.model;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains all the information about a player.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Players {

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

}
