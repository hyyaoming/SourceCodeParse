package org.lym.sourcecodeparse.source.parse.screenshot;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.lym.sourcecodeparse.R;

import java.util.List;

/**
 * Created by asus on 2018/7/11.
 */

public class ScreenAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ScreenAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tvScreenName, item);
    }
}
