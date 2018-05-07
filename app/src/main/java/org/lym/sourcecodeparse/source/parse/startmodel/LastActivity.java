package org.lym.sourcecodeparse.source.parse.startmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.lym.sourcecodeparse.MainActivity;
import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/18
 */

public class LastActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_last);
        findViewById(R.id.btn_act_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LastActivity.this, FirstActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume", "LastActivity onResume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("onNewIntent", "LastActivity newIntent");
    }
}
