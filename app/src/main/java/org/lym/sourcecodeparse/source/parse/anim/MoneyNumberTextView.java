package org.lym.sourcecodeparse.source.parse.anim;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/8
 */
public class MoneyNumberTextView extends AppCompatTextView {
    private float mNumber;
    private long mDuration = 1500;
    private String regex;
    public static final String INTREGEX = "%1$01.0f";//不保留小数，整数
    public static final String FLOATREGEX = "%1$01.2f";//保留2位小数

    public void showMoneyNumberAnim(float number, String regex) {
        this.mNumber = number;
        this.regex = regex;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(this, "number", 0, number);
        objectAnimator.setDuration(mDuration);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.start();
    }

    public float getNumber() {
        return mNumber;
    }

    public void setNumber(float number) {
        this.mNumber = number;
        setText(String.format(regex, number));
    }

    public MoneyNumberTextView(Context context) {
        this(context, null);
    }

    public MoneyNumberTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MoneyNumberTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
