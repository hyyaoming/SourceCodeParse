package org.lym.sourcecodeparse.source.parse.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/15
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ActivityManage.instance().addActivityToStack(this);
        initView();
        bindListener();
        initLog();
        startTask();
    }

    protected abstract void startTask();

    private void initLog() {
        int size = ActivityManage.instance().getActivityStack().size();
        Log.d(TAG, "activity stack size：" + size);
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void bindListener();


}
