package org.lym.sourcecodeparse.source.parse.screenshot;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by asus on 2018/7/9.
 */

public class ConvertPicture {
    /**
     * layoutId转bttMap
     *
     * @param layoutId 布局资源文件
     * @param context  上下文
     */
    public static Bitmap layoutConvertBitmap(int layoutId, Context context) {
        View view = LayoutInflater.from(context).inflate(layoutId, null);
        //这类可以对view里面的内容进行赋值操作
        //这里有点需要注意，如果赋值操作有网络操作，那么只能等网络操作结束后才能进行转换工作
        //由于这里只是一个布局资源文件，没有在页面上加载过，所以需要自行进行布局测量和绘制。
        layoutView(view, context);
        return viewConvertBitmapOne(view);
    }

    /**
     * view转bitmap
     *
     * @param view 需要进行转换的bitmap
     * @return 返回转换后的bitmap
     */
    public static Bitmap viewConvertBitmapTwo(View view) {
        Bitmap bitmap = null;
        if (null != view && view.getMeasuredWidth() != 0) {
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache();
            bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.destroyDrawingCache();
        }
        return bitmap;
    }

    /**
     * View转bitmap
     *
     * @param view 需要转换的view
     * @return 转换后的bitmap
     */
    public static Bitmap viewConvertBitmapOne(View view) {
        if (view != null) {
            Bitmap ret = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(ret);
            Drawable bgDrawable = view.getBackground();
            if (bgDrawable != null) {
                bgDrawable.draw(canvas);
            } else {
                canvas.drawColor(Color.WHITE);
            }
            view.draw(canvas);
            return ret;
        }
        return null;
    }

    /**
     * 手动绘制布局，这里一般宽度测量模式设置为准确模式，大小为屏幕宽度
     * 如果设置为未知模式会影响View当中的显示效果，转换后的bitmap效果不佳。
     *
     * @param view    需要测量的view
     * @param context 上下文
     */
    private static void layoutView(View view, Context context) {
        int width = context.getResources().getDisplayMetrics().widthPixels;
        view.layout(0, 0, width, 0);
        //为了不影响view内容展示和bitmap显示效果，这里设置为精确模式，宽度为屏幕宽度
        int measuredWidth = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int measuredHeight = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        /* 当然，measure完后，并不会实际改变View的尺寸，需要调用View.layout方法去进行布局。
        按示例调用layout函数后，View的大小将会变成你想要设置成的大小。*/
        view.measure(measuredWidth, measuredHeight);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public static Bitmap shotRecyclerView(RecyclerView view, Context context) {
        layoutView(view, context);
        //获取设置的adapter
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter == null) {
            return null;
        }
        //创建保存截图的bitmap
        Bitmap bigBitmap = null;
        //获取item的数量
        int size = adapter.getItemCount();
        //recycler的完整高度 用于创建bitmap时使用
        int height = 0;
        //获取最大可用内存
        int subCount = 0;
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        RecyclerView.LayoutManager manager = view.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            subCount = ((GridLayoutManager) manager).getSpanCount();
        }
        // 使用1/8的缓存
        final int cacheSize = maxMemory / 8;
        //把每个item的绘图缓存存储在LruCache中
        android.support.v4.util.LruCache<String, Bitmap> bitmapCache = new android.support.v4.util.LruCache<>(cacheSize);
        for (int i = 0; i < size; i++) {
            //手动调用创建和绑定ViewHolder方法，
            RecyclerView.ViewHolder holder = adapter.createViewHolder(view, adapter.getItemViewType(i));
            adapter.onBindViewHolder(holder, i);
            //测量
            holder.itemView.measure(
                    View.MeasureSpec.makeMeasureSpec(view.getWidth() / 2, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            //布局
            holder.itemView.layout(0, 0, holder.itemView.getMeasuredWidth(),
                    holder.itemView.getMeasuredHeight());
            //开启绘图缓存
            holder.itemView.setDrawingCacheEnabled(true);
            holder.itemView.buildDrawingCache();
            Bitmap drawingCache = holder.itemView.getDrawingCache();
            if (drawingCache != null) {
                bitmapCache.put(String.valueOf(i), drawingCache);
            }
            //获取itemView的实际高度并累加
            if (i % subCount == 0) {
                height += holder.itemView.getMeasuredHeight();
            }
        }
        //根据计算出的recyclerView高度创建bitmap
        bigBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), height, Bitmap.Config.RGB_565);
        //创建一个canvas画板
        Canvas canvas = new Canvas(bigBitmap);
        //获取recyclerView的背景颜色
        Drawable background = view.getBackground();
        //画出recyclerView的背景色 这里只用了color一种 有需要也可以自己扩展
        if (background instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) background;
            int color = colorDrawable.getColor();
            canvas.drawColor(color);
        }
        //当前bitmap的高度
        int top = 0;
        //画笔
        Paint paint = new Paint();
        for (int i = 0; i < size; i++) {
            Bitmap bitmap = bitmapCache.get(String.valueOf(i));
            if ((i + 1) % subCount == 0) {
                canvas.drawBitmap(bitmap, view.getMeasuredWidth() / 2, top, paint);
                top += bitmap.getHeight();
            } else {
                canvas.drawBitmap(bitmap, 0, top, paint);
            }
            //如果有在第二次截图时崩溃等状况，注掉下面方法就好，原因我还没想明白。。。
            bitmap.recycle();
        }
        return bigBitmap;
    }

    /**
     * 将一张bitmap插入到系统中
     *
     * @param context the context
     * @param bmp     this bitmap
     */
    public static void saveImageToGallery(Context context, Bitmap bmp) {
        if (null != bmp) {
            // 首先保存图片
            File appDir = new File(Environment.getExternalStorageDirectory(), "HuanShang");
            if (!appDir.exists()) {
                appDir.mkdir();
            }
            String fileName = System.currentTimeMillis() + ".jpg";
            File file = new File(appDir, fileName);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 其次把文件插入到系统图库
            try {
                MediaStore.Images.Media.insertImage(context.getContentResolver(),
                        file.getAbsolutePath(), fileName, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // 最后通知图库更新
            syncAlbum(fileName, context);
        }
    }

    /**
     * 同步刷新系统相册
     *
     * @param imageUrl 图片路径
     */
    private static void syncAlbum(String imageUrl, Context context) {
        final Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        final Uri contentUri = Uri.fromFile(FileUtils.createFileFrom(imageUrl, context).getAbsoluteFile());
        scanIntent.setData(contentUri);
        context.getApplicationContext().sendBroadcast(scanIntent);
    }
}
