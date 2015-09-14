package zerobase.us.fulltime.base;

import android.app.Fragment;
import android.content.Context;

import zerobase.us.fulltime.interfaces.SwitchFragmentInterface;

/**
 * This is the fragment that will serve as the base for all the fragments.
 * Created by Sripadmanaban on 9/14/2015.
 */
public class BaseFragment extends Fragment {

    private static final String ERROR_MESSAGE
            = "SwitchFragmentInterface has not been implemented in the activity.";

    protected SwitchFragmentInterface switchFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            switchFragment = (SwitchFragmentInterface) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(ERROR_MESSAGE);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        switchFragment = null;
    }
}
