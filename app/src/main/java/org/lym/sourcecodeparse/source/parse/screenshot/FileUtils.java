package org.lym.sourcecodeparse.source.parse.screenshot;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by asus on 2018/7/12.
 */

public class FileUtils {
    private static final int LENGTH = 7;

    private FileUtils() {
        //no instance
    }

    /**
     * 根据一个地址创建一个文件
     *
     * @param url url地址
     * @return 返回创建后的文件
     */
    public static File createFileFrom(String url, Context context) {
        String fileName = getFileSuffixFrom(url);
        File file = new File(getAppAlbumDir(context), fileName);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 返回文件路径
     *
     * @param url 地址
     * @return 返回路径
     */
    public static String getFileSuffixFrom(String url) {
        if (url.contains(".")) {
            String fileSuffix = url.substring(url.lastIndexOf("."), url.length());
            if (fileSuffix != null && fileSuffix.length() < LENGTH) {
                return fileSuffix;
            } else {
                return System.currentTimeMillis() + ".jpg";
            }
        }
        return System.currentTimeMillis() + ".jpg";
    }

    /**
     * 返回指定文件路径
     *
     * @return 返回文件
     */
    public static File getAppAlbumDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return context.getExternalFilesDir("Album");
        } else {
            return new File(context.getFilesDir(), "Album/");
        }
    }

}
