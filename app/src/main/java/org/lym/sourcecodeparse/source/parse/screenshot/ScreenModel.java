package org.lym.sourcecodeparse.source.parse.screenshot;

import android.graphics.Bitmap;

/**
 * Created by asus on 2018/7/11.
 */

public class ScreenModel {
    private String name;
    private Bitmap bitmap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
