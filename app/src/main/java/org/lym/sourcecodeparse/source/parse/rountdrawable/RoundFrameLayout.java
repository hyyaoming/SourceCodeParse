package org.lym.sourcecodeparse.source.parse.rountdrawable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import org.lym.sourcecodeparse.utils.ViewHelper;

/**
 * author: ym.li
 * since: 2018/7/23
 */

public class RoundFrameLayout extends FrameLayout {
    public RoundFrameLayout(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        RoundButtonDrawable bg = RoundButtonDrawable.fromAttributeSet(context, attrs, defStyleAttr);
        ViewHelper.setBackgroundKeepingPadding(this, bg);
    }
}
