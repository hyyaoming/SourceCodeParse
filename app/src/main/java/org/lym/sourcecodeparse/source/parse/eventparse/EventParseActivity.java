package org.lym.sourcecodeparse.source.parse.eventparse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.lym.sourcecodeparse.MainActivity;
import org.lym.sourcecodeparse.R;

/**
 * doc 事件分发demo
 *
 * @author yaoming.li
 * @since 2018/4/16
 */

public class EventParseActivity extends AppCompatActivity {
    private static final String TAG = EventParseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_event_parse);
        initView();
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.d(TAG, "activity dispatchTouchEvent action");
//        return super.dispatchTouchEvent(ev);
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.d(TAG, "activity onTouchEvent action");
//        return super.onTouchEvent(event);
//    }

    private void initView() {
        Button mEventButton = findViewById(R.id.btn_event_parse);
        mEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "button onClick");
            }
        });

        mEventButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch execute action：" + event.getAction());
                return false;
            }
        });
    }

}
