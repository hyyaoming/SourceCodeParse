package org.lym.sourcecodeparse.source.parse.recyclerview.provider;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.GridClassifyModel;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;
import org.lym.sourcecodeparse.utils.ToastUtils;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class GoodsGirdItemProvider extends BaseItemProvider<GridClassifyModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MultipleItemEntity.GRID_CLASSIFY_ITEM;
    }

    @Override
    public int layout() {
        return R.layout.rv_multiple_grid_goods_item;
    }

    @Override
    public void convert(BaseViewHolder helper, GridClassifyModel data, int position) {
        helper.setText(R.id.rv_multiple_item_tv, data.getTitle());
        helper.setImageResource(R.id.rv_multiple_item_iv, data.getRes());
    }

    @Override
    public void onClick(BaseViewHolder helper, GridClassifyModel data, int position) {
        super.onClick(helper, data, position);
        ToastUtils.showToast(data.getTitle());
    }
}
