package org.lym.sourcecodeparse.source.parse.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/15
 */

public class ActivityA extends BaseActivity {

    private Button mBtnJumpB;

    @Override
    protected void startTask() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    Log.d("Activity", "ActivityA Test");
//                }
//            }
//        }).start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_a;
    }

    @Override
    protected void initView() {
        mBtnJumpB = findViewById(R.id.btn_jump_b);
    }

    @Override
    protected void bindListener() {
        mBtnJumpB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityB.open(ActivityA.this);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity", "OnPause");
    }

    public static void open(Activity activity) {
        activity.startActivity(new Intent(activity, ActivityA.class));
//        ActivityManage.instance().removeActivityToStack(activity);
    }
}
