package zerobase.us.fulltime.base;

import android.app.Activity;
import android.app.Fragment;

import zerobase.us.fulltime.interfaces.FragmentSwitch;

/**
 * This is the fragment that will serve as the base for all the fragments.
 * Created by Sripadmanaban on 9/14/2015.
 */
public class BaseFragment extends Fragment {

    private static final String ERROR_MESSAGE
            = "FragmentSwitch has not been implemented in the activity.";

    protected FragmentSwitch fragmentSwitch;

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentSwitch = (FragmentSwitch) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(ERROR_MESSAGE);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentSwitch = null;
    }
}
