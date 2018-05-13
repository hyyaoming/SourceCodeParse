package org.lym.sourcecodeparse.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class ToastUtils {
    private static Toast sToast = null;
    private static String sOldMsg;
    private static long sOneTime;
    private static long sTwoTime;
    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    private ToastUtils() {
        throw new RuntimeException("ToastUtils cannot be initialized");
    }

    /**
     * 初始化
     *
     * @param context 初始化
     */
    public static void init(Context context) {
        sContext = context;
    }

    /**
     * 吐司
     *
     * @param msg 文本
     */
    public static void showToast(String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(sContext, msg, Toast.LENGTH_LONG);
            sToast.show();
            sOneTime = System.currentTimeMillis();
        } else {
            sTwoTime = System.currentTimeMillis();
            if (!TextUtils.isEmpty(sOldMsg) && sOldMsg.equals(msg)) {
                if (sTwoTime > sOneTime) {
                    sToast.show();
                }
            } else {
                sOldMsg = msg;
                sToast.setText(msg);
                sToast.show();
            }
            sOneTime = sTwoTime;
        }
    }

    /**
     * 吐司
     *
     * @param id 资源id
     */
    public static void showToast(int id) {
        showToast(sContext.getString(id));
    }
}
