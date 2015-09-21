package zerobase.us.fulltime.model;

import com.google.gson.annotations.SerializedName;

/**
 * This is the class that contains the details about the team.
 * Created by Sripadmanaban on 9/21/2015.
 */
public class Teams {

    @SerializedName("_links")
    Links links;

    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("squadMarketValue")
    private String squardMarketValue;

    @SerializedName("crestUrl")
    private String crestURL;

}
