package zerobase.us.fulltime.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zerobase.us.fulltime.interfaces.SwitchFragmentInterface;

/**
 * This is the class that acts as the base for all the activities.
 * Created by Sripadmanaban on 9/14/2015.
 */
public class BaseActivity extends AppCompatActivity implements SwitchFragmentInterface {

    protected int fragmentContainerID;

    @Override
    public void switchFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(fragmentContainerID, fragment, fragment.getClass().getSimpleName());
        transaction.commit();
    }
}
