package org.lym.sourcecodeparse.source.parse.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.utils.StatusBarManager;

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
        initStatusBar();
        changeStatusBarTextColor();
    }

    protected void changeStatusBarTextColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    /**
     * 如下两种情况不满足需求，子类可重写
     */
    protected void initStatusBar() {
        if (enableStatusBar()) {
            if (topIsImage()) {
                StatusBarManager.setStatusBar(this, android.R.color.transparent, true);
            } else {
                StatusBarManager.setStatusBar(this, setStatusBarColor(), false);
            }
        }
    }

    /**
     * 方便于子类设置状态栏的颜色
     *
     * @return 返回状态栏的颜色
     */
    protected int setStatusBarColor() {
        return R.color.colorPrimary;
    }

    /**
     * 如果布局需侵入状态栏，子类可返回true,默认为false
     *
     * @return boolean
     */
    protected boolean topIsImage() {
        return false;
    }

    /**
     * 是否开启沉浸式模式，如果当前不需要开启沉浸式，子类返回false即可
     *
     * @return boolean
     */
    protected boolean enableStatusBar() {
        return true;
    }

    protected abstract void startTask();

    private void initLog() {
        int size = ActivityManage.instance().getActivityStack().size();
        Log.d(TAG, "activity stack size：" + size);
    }

    protected void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void bindListener();


}
