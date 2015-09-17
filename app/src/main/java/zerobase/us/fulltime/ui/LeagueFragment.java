package zerobase.us.fulltime.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import zerobase.us.fulltime.R;
import zerobase.us.fulltime.base.BaseFragment;
import zerobase.us.fulltime.util.AllLeaguesGridAdapter;

/**
 * Created by arvindchellapondy on 9/16/15.
 */
public class LeagueFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_leagues,container,false);
        ButterKnife.bind(this, view);

        return view;
    }
}
