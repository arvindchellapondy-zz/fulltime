package zerobase.us.fulltime.model.fixture;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains details about the result of a fixture.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Result {

    @SerializedName("goalsHomeTeam")
    private int goalsHomeTeam;

    @SerializedName("goalsAwayTeam")
    private int goalsAwayTeam;

}
