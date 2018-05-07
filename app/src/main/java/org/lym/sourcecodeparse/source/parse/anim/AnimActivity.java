package org.lym.sourcecodeparse.source.parse.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/7
 */
public class AnimActivity extends BaseActivity {
    private TextView mBtn;
    private RelativeLayout mRelayout;

    @Override
    protected void startTask() {

    }

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
                AnimatorSet set = new AnimatorSet();
                ObjectAnimator animator = ObjectAnimator.ofFloat(mBtn, "translationY", 0, mRelayout.getHeight()+10);
                ObjectAnimator aleObjectAnimator = ObjectAnimator.ofFloat(mBtn, "alpha", 0f, 1f);
                set.play(animator).with(aleObjectAnimator);
                set.setDuration(1000);
                set.start();
                break;
            case R.id.scale:
                AnimatorSet set1 = new AnimatorSet();
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(mBtn, "translationY", mRelayout.getHeight()+10, 1);
                ObjectAnimator aleObjectAnimator1 = ObjectAnimator.ofFloat(mBtn, "alpha", 1f, 0f);
                set1.play(animator1).with(aleObjectAnimator1);
                set1.setDuration(1000);
                set1.start();
                break;
            case R.id.alpha:
                showToast("渐变动画");
                break;
            case R.id.rotation:
                showToast("旋转动画");
                break;
            case R.id.anim_set:
                showToast("组合动画");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initView() {
        mBtn = findViewById(R.id.btn_anim);
        mRelayout = findViewById(R.id.re_layout);
    }

    @Override
    protected void bindListener() {
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("set valueAnimator");
            }
        });
    }
}
