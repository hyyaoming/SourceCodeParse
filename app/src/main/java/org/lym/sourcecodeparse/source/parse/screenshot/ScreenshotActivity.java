package org.lym.sourcecodeparse.source.parse.screenshot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.DataServer;

/**
 * layoutId to bitmap
 * <p>
 * Created by asus on 2018/7/9.
 */

public class ScreenshotActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_screenshot;
    }

    @Override
    protected void initView() {
    }


    @Override
    protected void bindListener() {
        findViewById(R.id.btnLayoutConvertBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        findViewById(R.id.btnLayoutConvertBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScreenshotActivity.this,LayoutConvertBitmapActivity.class));
            }
        });
        findViewById(R.id.btnViewConvertBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScreenshotActivity.this,ViewConvertBitmapActivity.class));
            }
        });
        findViewById(R.id.btnListConvertBitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScreenshotActivity.this,ListConvertBitmapActivity.class));
            }
        });

    }
}
