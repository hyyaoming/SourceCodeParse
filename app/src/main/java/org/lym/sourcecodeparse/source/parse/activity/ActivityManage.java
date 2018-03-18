package org.lym.sourcecodeparse.source.parse.activity;

import android.app.Activity;

import java.util.Set;
import java.util.Stack;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/15
 */

public class ActivityManage {
    private static ActivityManage sManage;
    private static Stack<Activity> sStack = new Stack<>();

    private ActivityManage() {

    }

    public void addActivityToStack(Activity activity) {
        if (null != activity) {
            sStack.push(activity);
        }
    }

    public void removeActivityToStack(Activity activity) {
        if (null != activity) {
            sStack.remove(activity);
        }
    }

    public Stack<Activity> getActivityStack() {
        return sStack;
    }


    public static ActivityManage instance() {
        if (null == sManage) {
            synchronized (ActivityManage.class) {
                if (null == sManage) {
                    sManage = new ActivityManage();
                }
            }
        }
        return sManage;
    }
}
