package zerobase.us.fulltime.ui;

import android.animation.Animator;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import zerobase.us.fulltime.R;
import zerobase.us.fulltime.base.BaseFragment;
import zerobase.us.fulltime.model.Leagues;
import zerobase.us.fulltime.util.AllLeaguesGridAdapter;
import zerobase.us.fulltime.util.GUIUtils;

/**
 * Created by arvindchellapondy on 9/14/15.
 */
public class AllLeaguesFragment extends BaseFragment {

    @Bind(R.id.all_leagues_grid_view)
    GridView gridView;

    AllLeaguesGridAdapter gridAdapter;

    @Bind(R.id.reveal_view)
     View revealView;

    private int[] colors;

    private ArrayList<Leagues> leagues;
    private String[] leagueImages;

    public static AllLeaguesFragment newInstance() {
        AllLeaguesFragment fragment = new AllLeaguesFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_leagues,container,false);
        ButterKnife.bind(this, view);
        gridAdapter = new AllLeaguesGridAdapter(getActivity());
        colors = getActivity().getResources().getIntArray(R.array.league_material_colors_array);
        leagueImages = getActivity().getResources().getStringArray(R.array.league_image_links);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupView();

    }

    private void setupView(){
        getLeagueData();
        gridAdapter.addLeagues(leagues);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                revealView.setBackgroundColor(colors[position]);

                int [] location = new int[2];
                view.getLocationOnScreen(location);

                int cx = (location[0] + (view.getWidth() / 2));
                int cy = location[1] + (GUIUtils.getStatusBarHeight(getActivity()) / 2);

                GUIUtils.showRevealEffect(revealView, cx, cy, revealAnimationListener);
            }
        });
    }

    private void getLeagueData(){
        leagues = new ArrayList<>();
        leagues.add(new Leagues(1,"Premier League",R.drawable.premier_league_logo));
        leagues.add(new Leagues(1,"Primera Division",R.drawable.primera_division_logo));
        leagues.add(new Leagues(1,"Bundesliga",R.drawable.bundesliga_logo));
        leagues.add(new Leagues(1,"Serie A",R.drawable.serie_a_logo));
        leagues.add(new Leagues(1,"Ligue 1",R.drawable.ligue1_logo));
        leagues.add(new Leagues(1, "Eredivisie", R.drawable.eredivisie_logo));
        leagues.add(new Leagues(1, "Primeira Liga", R.drawable.primeira_league));
        leagues.add(new Leagues(1, "Champions League", R.drawable.champions_league_logo));
    }

    Animator.AnimatorListener revealAnimationListener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {}

        @Override
        public void onAnimationEnd(Animator animation) {

            switchFragment.switchFragment(new LeagueFragment(),true);

        }

        @Override
        public void onAnimationCancel(Animator animation) {}

        @Override
        public void onAnimationRepeat(Animator animation) {}
    };


}
