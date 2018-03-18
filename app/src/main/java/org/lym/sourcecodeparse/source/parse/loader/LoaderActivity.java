package org.lym.sourcecodeparse.source.parse.loader;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/7
 */

public class LoaderActivity extends AppCompatActivity implements PicCollection.LoadCallBack {

    private PicCollection picCollection = new PicCollection();
    private static final String TAG = LoaderActivity.class.getSimpleName();
    private TextView mTvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_loader);
        initView();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            picCollection.load(this, this);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private void initView() {
        mTvContent = findViewById(R.id.tv_content);
    }

    public static void open(Context context) {
        context.startActivity(new Intent(context, LoaderActivity.class));
    }


    @Override
    public void loadResult(Cursor cursor) {
        Log.d(TAG, "cursor：" + cursor.getCount());
        StringBuilder fileName = new StringBuilder();
        while (cursor.moveToNext()) {
            Log.d(TAG, cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA)));
            fileName.append(cursor.getString(cursor.getColumnIndex("bucket_display_name"))).append("\n");
        }
        mTvContent.setText(fileName.toString());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0) {
            picCollection.load(this, this);
        }
    }

    @Override
    public void loadReset() {

    }
}
