package org.lym.sourcecodeparse.source.parse.anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import org.lym.sourcecodeparse.R;

/**
 * Created by asus on 2018/7/8.
 */

public class JumpView extends AppCompatTextView implements Animatable, View.OnClickListener {
    private Paint mBackGroundPaint;
    private Paint mCircleBckGroundPaint;


    private int mCircleBackGroundColor;
    private int mCircleColor;
    private JumpCallBack mCallBack;

    private ObjectAnimator mAnim;

    private static final int DEFAULT_DURATION = 2000;
    private int mDuration;
    private int mAngle;
    private RectF mOval = new RectF();
    private static final String TAG = JumpView.class.getSimpleName();

    public JumpView(Context context) {
        this(context, null);
    }

    public JumpView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JumpView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        @SuppressLint("Recycle") TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.JumpView, defStyleAttr, 0);
        mDuration = array.getInt(R.styleable.JumpView_duration, DEFAULT_DURATION);
        mCircleBackGroundColor = array.getColor(R.styleable.JumpView_circle_background_color, Color.BLUE);
        mCircleColor = array.getColor(R.styleable.JumpView_circle_color, Color.BLACK);
        array.recycle();
        init();
    }

    public void setAngle(int angle) {
        if (mAngle != angle) {
            mAngle = angle;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int strokeWidth = getWidth() / 18;
        mCircleBckGroundPaint.setStrokeWidth(strokeWidth);
        final int circlePadding = ((int) (strokeWidth / 2 + 0.5f));
        mOval.set(circlePadding, circlePadding, getMeasuredWidth() - circlePadding, getMeasuredHeight() - circlePadding);
        Log.d(TAG, "circlePadding：" + circlePadding);
        Log.d(TAG, "mAngle：" + mAngle);

        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, mBackGroundPaint);
        canvas.drawArc(mOval, -90 + mAngle, mAngle, false, mCircleBckGroundPaint);
        canvas.drawArc(mOval, 90 + mAngle, mAngle, false, mCircleBckGroundPaint);
        super.onDraw(canvas);
    }

    public void setJumpCallBack(JumpCallBack callBack) {
        this.mCallBack = callBack;
    }

    @SuppressLint("ObjectAnimatorBinding")
    @Override
    public void start() {
        if (!isRunning()) {
            if (getVisibility() != View.VISIBLE) {
                setVisibility(VISIBLE);
            }
            setAlpha(0);
            animate().alpha(1).setDuration(mDuration / 3).start();
            mAnim = ObjectAnimator.ofInt(this, "angle", 0, 180);
            mAnim.setDuration(mDuration);
            mAnim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    if (null != mCallBack) {
                        mCallBack.animEndCallBack();
                    }
                }
            });
            mAnim.start();
        }
    }

    @Override
    public void stop() {
        if (null != mAnim) {
            mAnim.cancel();
        }
    }

    @Override
    public boolean isRunning() {
        return mAnim != null && mAnim.isRunning();
    }

    private void init() {
        if (null == mCircleBckGroundPaint) {
            mCircleBckGroundPaint = new Paint();
            mCircleBckGroundPaint.setStyle(Paint.Style.STROKE);
            mCircleBckGroundPaint.setColor(mCircleBackGroundColor);
            mCircleBckGroundPaint.setAntiAlias(true);
        }
        if (null == mBackGroundPaint) {
            mBackGroundPaint = new Paint();
            mBackGroundPaint.setColor(mCircleColor);
            mBackGroundPaint.setStyle(Paint.Style.FILL);
            mBackGroundPaint.setAntiAlias(true);
        }
    }

    public interface JumpCallBack {
        void animEndCallBack();

        void jumpClickCallBack();
    }

    @Override
    public void onClick(View v) {
        stop();
        if (null != mCallBack) {
            mCallBack.jumpClickCallBack();
        }
    }
}
