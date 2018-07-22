package org.lym.sourcecodeparse.source.parse.dialog;

import android.view.View;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;

/**
 * Created by asus on 2018/7/17.
 */

public class DialogActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.module_activity_dialog;
    }

    @Override
    protected void initView() {
        findViewById(R.id.btnShowLoadingDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TipDialog.Builder(DialogActivity.this)
                        .setTipWord("正在加载")
                        .setIconType(TipDialog.Builder.ICON_TYPE_LOADING)
                        .create().show();
            }
        });
    }

    @Override
    protected void bindListener() {

    }
}
