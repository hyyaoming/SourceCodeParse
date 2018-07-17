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

public class ActivityB extends BaseActivity {

    private Button mBtnJumpA;

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity", "onResume");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_b;
    }

    @Override
    protected void initView() {
        mBtnJumpA = findViewById(R.id.btn_jump_a);
    }

    public static void open(Activity activity) {
        activity.startActivity(new Intent(activity, ActivityB.class));
//        ActivityManage.instance().removeActivityToStack(activity);
    }

    @Override
    protected void bindListener() {
        mBtnJumpA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityA.open(ActivityB.this);
            }
        });
    }
}
