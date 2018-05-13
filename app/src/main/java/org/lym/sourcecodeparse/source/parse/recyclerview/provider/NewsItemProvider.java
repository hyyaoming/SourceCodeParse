package org.lym.sourcecodeparse.source.parse.recyclerview.provider;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.NewsModel;
import org.lym.sourcecodeparse.utils.ToastUtils;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class NewsItemProvider extends BaseItemProvider<NewsModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MultipleItemEntity.NEWS_LIST_ITEM;
    }

    @Override
    public int layout() {
        return R.layout.rv_multiple_news_item;
    }

    @Override
    public void convert(BaseViewHolder helper, NewsModel data, int position) {
        Glide.with(mContext).load(data.getUrl()).into((ImageView) helper.getView(R.id.rv_multiple_item_new_iv));
        helper.setText(R.id.rv_multiple_item_new_tv_name,data.getTitle());
        helper.setText(R.id.rv_multiple_item_new_tv_time,data.getTime());
        helper.setText(R.id.rv_multiple_item_new_tv_source,data.getSource());
    }

    @Override
    public void onClick(BaseViewHolder helper, NewsModel data, int position) {
        super.onClick(helper, data, position);
        ToastUtils.showToast(data.getTitle()
        );
    }
}
