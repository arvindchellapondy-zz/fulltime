package zerobase.us.fulltime.model;

import com.google.gson.annotations.SerializedName;

import zerobase.us.fulltime.model.fixture.Result;

/**
 * This class contains the details about a fixture.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Fixture {

    @SerializedName("_links")
    Links links;

    @SerializedName("date")
    private String date;

    @SerializedName("status")
    private String status;

    @SerializedName("matchDay")
    private int matchDay;

    @SerializedName("homeTeamName")
    private String homeTeamName;

    @SerializedName("awayTeamName")
    private String awayTeamName;

    @SerializedName("result")
    Result result;

}
