package org.lym.sourcecodeparse.source.parse.screenshot;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.DataServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 布局文件转bitmap
 * Created by asus on 2018/7/13.
 */

public class LayoutConvertBitmapActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_layout_convert_bitmap;
    }

    @Override
    protected void initView() {
        Button mBtnLayoutConvertBitmap = findViewById(R.id.btnLayoutConvertBitmap);
        final ImageView iv = findViewById(R.id.ivConvertBitmap);
        mBtnLayoutConvertBitmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ConvertPicture.layoutConvertBitmap(R.layout.layout_convert_bitmap, LayoutConvertBitmapActivity.this);
                iv.setImageBitmap(compressImage(bitmap));
            }
        });
    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @return
     */
    public Bitmap compressImage(Bitmap image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 90;
        while (baos.toByteArray().length / 1024 > 100) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            baos.reset(); // 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10
        }
        ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        return BitmapFactory.decodeStream(isBm, null, null);
    }

    @Override
    protected void bindListener() {

    }
}
