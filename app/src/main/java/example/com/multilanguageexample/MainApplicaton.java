package example.com.multilanguageexample;

import android.app.Application;

import com.iamsourav.sohoz.SohozUtil;

/**
 * Created by Zipu on 12/28/2017.
 */

public class MainApplicaton extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SohozUtil.getInstance().initSohozUtil(getApplicationContext());
    }
}
