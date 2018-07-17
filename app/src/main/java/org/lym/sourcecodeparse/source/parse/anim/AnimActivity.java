package org.lym.sourcecodeparse.source.parse.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/7
 */
public class AnimActivity extends BaseActivity {
    private Button mBtn;
    private MoneyNumberTextView mMoneyTv;
    private PointView mPointView;

    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_anim;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.translation:
                ObjectAnimator translationAnim = ObjectAnimator.ofFloat(mBtn, "translationY", 0, 150, 0);
                translationAnim.setDuration(1000);
                translationAnim.start();
                break;
            case R.id.scale:
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator scaleAnimX = ObjectAnimator.ofFloat(mBtn, "scaleX", 1f, 0f, 1f);
                ObjectAnimator scaleAnimY = ObjectAnimator.ofFloat(mBtn, "scaleY", 1f, 0f, 1f);
                set.setDuration(1000);
                set.play(scaleAnimX).with(scaleAnimY);
                set.start();
                break;
            case R.id.alpha:
                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(mBtn, "alpha", 0f, 1f);
                alphaAnim.setDuration(1000);
                alphaAnim.start();
                break;
            case R.id.rotation:
                ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(mBtn, "rotation", 0f, 360f);
                rotationAnim.setDuration(1000);
                rotationAnim.start();
                break;
            case R.id.anim_set:
                AnimatorSet animSet = new AnimatorSet();
                ObjectAnimator translationX = ObjectAnimator.ofFloat(mBtn, "translationX", 0, 150);
                ObjectAnimator translationY = ObjectAnimator.ofFloat(mBtn, "translationY", 0, 150);
                ObjectAnimator rotation = ObjectAnimator.ofFloat(mBtn, "rotation", 0f, 360f);
                animSet.setDuration(2000);
                animSet.play(translationX).with(translationY).with(rotation);
                animSet.start();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {
        mBtn = findViewById(R.id.btn_anim);
        mMoneyTv = findViewById(R.id.tv_money);
        mPointView = findViewById(R.id.pointView);
    }

    @Override
    protected void bindListener() {
        mMoneyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMoneyTv.showMoneyNumberAnim(2359.50f, MoneyNumberTextView.FLOATREGEX);
            }
        });
        mPointView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPointView.starAnim();
            }
        });
    }
}
