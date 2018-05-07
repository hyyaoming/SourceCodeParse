package org.lym.sourcecodeparse.source.parse.design;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/29
 */

public class ShadowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.module_activity_shadow_layout);
    }

    public static void  action(Context context){
        context.startActivity(new Intent(context,ShadowActivity.class));
    }
}
