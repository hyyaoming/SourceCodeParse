package org.lym.sourcecodeparse.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class StatusBarManager {
    private static final String TAG = "StatusBarManager";

    /**
     * 该方法用来设置状态栏相关的配置,统一将内容布局入侵到状态栏
     * 为内容布局添加一个高度为statusBar的View
     * 如需做完全沉浸式则可将color参数设置为透明颜色,然后topIsImage参数返回true
     *
     * @param activity   Activity
     * @param color      Color   状态栏的颜色，以及statusView的颜色
     * @param topIsImage 是否完成沉浸式
     */
    public static void setStatusBar(Activity activity, int color, boolean topIsImage) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            if (Build.BRAND.equals("HuaWei")) {
                //此标记位是用来设置将状态栏设置成透明，在5.0以后这属于一种极端情况
                window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            } else {
                //清除上面的标记位
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
            //此标记位表示当前窗口可为状态栏绘制背景
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getColor(activity, color));
            /**
             * View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN    Activity全屏显示，但状态栏不会被隐藏覆盖
             * ，状态栏依然可见，Activity顶端布局部分会被状态遮住
             */
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        addStatusBar(activity, color, topIsImage);
    }

    private static int getColor(Activity activity, int colorRes) {
        return activity.getResources().getColor(colorRes);
    }

    private static void addStatusBar(Activity activity, int color, boolean topIsImage) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View statusBarView = viewGroup.getChildAt(0);
        setPadding(statusBarView, topIsImage, activity);
        //改变颜色时避免重复添加statusBarView
        if (statusBarView != null && statusBarView.getMeasuredHeight() == getStatusBarHeight(activity)) {
            statusBarView.setBackgroundColor(getColor(activity, color));
            return;
        }
        statusBarView = new View(activity);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(activity));
        statusBarView.setBackgroundColor(getColor(activity, color));
        viewGroup.addView(statusBarView, lp);
    }

    private static void setPadding(View view, boolean topIsImage, Activity activity) {
        if (!topIsImage) {
            view.setPadding(0, getStatusBarHeight(activity), 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
    }

    /**
     * 返回系统状态栏的高度
     *
     * @param context 上下文
     * @return 返回系统状态栏的高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
