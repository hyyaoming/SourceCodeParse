package org.lym.sourcecodeparse.source.parse.intentservice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.lym.sourcecodeparse.R;

/**
 * intentService sample
 * <p>
 * Created by asus on 2018/3/3.
 */

public class IntentServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_intent_service);
        bindView();
    }

    private ProgressBar mProgress;
    private LocalBroadcastManager mProgressBroadCastManager;
    private TextView mTvProgress;
    private MyProgressBroadCast mBroadcast;
    private TextView mTvServiceState;


    @Override
    protected void onResume() {
        super.onResume();
        mProgressBroadCastManager = LocalBroadcastManager.getInstance(this);
        mBroadcast = new MyProgressBroadCast();
        mProgressBroadCastManager.registerReceiver(mBroadcast, getIntentFilter());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProgressBroadCastManager.unregisterReceiver(mBroadcast);
    }

    private IntentFilter getIntentFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(MyIntentService.PROGRESS_ACTION);
        return filter;
    }

    private void bindView() {
        Button mBtnOpenService = findViewById(R.id.btn_open_intent_service);
        mProgress = findViewById(R.id.progress);
        mTvServiceState = findViewById(R.id.tv_service_state);
        mTvProgress = findViewById(R.id.tv_progress);
        mBtnOpenService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyIntentService.startService(IntentServiceActivity.this);
            }
        });
    }

    public static void open(Activity activity) {
        activity.startActivity(new Intent(activity, IntentServiceActivity.class));
    }

    private class MyProgressBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (null != intent && intent.getAction().equals(MyIntentService.PROGRESS_ACTION)) {
                int count = intent.getIntExtra(MyIntentService.PROGRESS_COUNT, 0);
                mProgress.setProgress(count);
                mTvServiceState.setText(count < 100 ? "intentService运行中" : "intentService结束运行");
                mTvProgress.setText(count + "%");
            }
        }
    }
}
