package org.lym.sourcecodeparse.source.parse.startmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.lym.sourcecodeparse.R;

/**
 * doc  第一个activity
 *
 * @author yaoming.li
 * @since 2018/3/18
 */

public class FirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_first);
        findViewById(R.id.btn_act_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "FirstActivity onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("onNewIntent", "FirstActivity newIntent");
    }

    public static void open(Activity activity) {
        activity.startActivity(new Intent(activity, FirstActivity.class));
    }
}
