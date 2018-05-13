package org.lym.sourcecodeparse.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import org.lym.sourcecodeparse.utils.ToastUtils;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context sContext = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        ToastUtils.init(sContext);
    }

    public static Context getContext() {
        return sContext;
    }

}
