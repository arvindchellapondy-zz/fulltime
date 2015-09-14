package zerobase.us.fulltime.interfaces;

import android.app.Fragment;

/**
 * This is the interface that is going to be used to switch fragments.
 * Created by Sripadmanaban on 9/14/2015.
 */
public interface SwitchFragmentInterface {

    /**
     * This function is used to switch fragments.
     *
     * @param fragment       A fragment object that contains the fragment. The fragment must have
     *                       the bundle in it if it needs it.
     * @param addToBackStack A boolean that, if true means it should be added to the back stack
     *                       else not to be added to the back stack.
     */
    void switchFragment(Fragment fragment, boolean addToBackStack);
}
