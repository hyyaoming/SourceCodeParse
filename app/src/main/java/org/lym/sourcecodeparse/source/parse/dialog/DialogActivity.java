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
                CustomProcessDialog.show(DialogActivity.this, "加载中...");
            }
        });
    }

    @Override
    protected void bindListener() {

    }
}
