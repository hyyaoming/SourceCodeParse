package org.lym.sourcecodeparse.source.parse.rountdrawable;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import org.lym.sourcecodeparse.utils.ViewHelper;

/**
 * author: ym.li
 * since: 2018/7/24
 */

public class RoundButton extends AppCompatButton {
    public RoundButton(Context context) {
        super(context);
        init(context, null, 0);
    }

    public RoundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public RoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        RoundButtonDrawable bg = RoundButtonDrawable.fromAttributeSet(context, attrs, defStyleAttr);
        ViewHelper.setBackgroundKeepingPadding(this, bg);
    }
}
