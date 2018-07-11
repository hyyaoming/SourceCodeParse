package org.lym.sourcecodeparse.source.parse.screenshot;

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
    private ImageView mIvScreen;

    @Override
    protected void startTask() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_screenshot;
    }

    @Override
    protected void initView() {
        Button mBtn = findViewById(R.id.btnConvertPicture);
        mIvScreen = findViewById(R.id.ivScreen);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Bitmap bitmap = ConvertPicture.shotRecyclerView(initPicture(), ScreenshotActivity.this);
                mIvScreen.setImageBitmap(bitmap);
            }
        });
    }

    private RecyclerView initPicture() {
        RecyclerView mRv = (RecyclerView) getLayoutInflater().inflate(R.layout.layout_convert_rv, null);
        mRv.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRv.setLayoutManager(manager);
        ScreenAdapter adapter = new ScreenAdapter(R.layout.screen_rv_item, DataServer.getScreenList());
        mRv.setAdapter(adapter);
        return mRv;
    }

    @Override
    protected void bindListener() {

    }
}
