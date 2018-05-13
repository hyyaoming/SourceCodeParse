package org.lym.sourcecodeparse.source.parse.recyclerview.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.GuessModel;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class GuessItemProvider extends BaseItemProvider<GuessModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MultipleItemEntity.GUESS_YOU_LIKE;
    }

    @Override
    public int layout() {
        return R.layout.rv_multiple_guess_you_like_item;
    }

    @Override
    public void convert(BaseViewHolder helper, GuessModel data, int position) {
        helper.setText(R.id.multiple_guess_you_like_tv, data.getGuess());
        helper.addOnClickListener(R.id.multiple_guess_you_like_tv);
    }
}
