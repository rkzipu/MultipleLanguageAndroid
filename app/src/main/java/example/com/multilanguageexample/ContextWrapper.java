package example.com.multilanguageexample;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.Log;

import java.util.Locale;

public class ContextWrapper extends android.content.ContextWrapper {
    private static final String TAG = "ContextWrapper";
public ContextWrapper(Context base) {
    super(base);
}

public static ContextWrapper wrap(Context context, Locale newLocale) {
    Resources res = context.getResources();
    Configuration configuration = res.getConfiguration();

    if (isAtLeast24Api()) {
        configuration.setLocale(newLocale);

        LocaleList localeList = new LocaleList(newLocale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        context = context.createConfigurationContext(configuration);
        Log.d(TAG, "wrap() called with: context = [" + context + "], newLocale = [" + newLocale + "]");

    } else {
        configuration.setLocale(newLocale);
        context = context.createConfigurationContext(configuration);
    }

    return new ContextWrapper(context);
}

    private static boolean isAtLeast24Api() {
        return Build.VERSION.SDK_INT>=24;
    }
}