package example.com.multilanguageexample;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.iamsourav.sohoz.PreferenceUtil;
import com.iamsourav.sohoz.SohozUtil;

import java.util.Locale;

import static example.com.multilanguageexample.MainActivity.SHARED_PRE_KEY_LANGUAGE_STATE;

/**
 * Created by Zipu on 12/28/2017.
 */

public class BaseActivity extends AppCompatActivity{
    private static final String TAG = "BaseActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        String language = PreferenceUtil.getInstance().getStringValue(SHARED_PRE_KEY_LANGUAGE_STATE, "en");
        Log.d(TAG, "attachBaseContext() called with: newBase = [" + language + "]");
        Locale newLocale = new Locale(language);
        // .. create or get your new Locale object here.
        Context context = ContextWrapper.wrap(newBase, newLocale);


        super.attachBaseContext(context);
    }
}
