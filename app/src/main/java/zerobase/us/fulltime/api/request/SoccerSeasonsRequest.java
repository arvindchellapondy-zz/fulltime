package zerobase.us.fulltime.api.request;

import zerobase.us.fulltime.api.response.SoccerSeasonsResponse;
import zerobase.us.fulltime.base.request.BaseSpiceRequest;
import zerobase.us.fulltime.interfaces.api.FootballRequestManager;

/**
 * This is the class that is used to make a request to get the information about a season.
 * Created by Sripadmanaban on 9/24/2015.
 */
public class SoccerSeasonsRequest
        extends BaseSpiceRequest<SoccerSeasonsResponse, FootballRequestManager> {

    public SoccerSeasonsRequest() {
        super(SoccerSeasonsResponse.class, FootballRequestManager.class);
    }

    @Override
    public Object getCacheKey() {
        return null;
    }

    @Override
    public SoccerSeasonsResponse loadDataFromNetwork() throws Exception {
        return getService().getSeasons();
    }
}
