package org.lym.sourcecodeparse.source.parse.recyclerview.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.MultipleItemRvAdapter;

import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;
import org.lym.sourcecodeparse.source.parse.recyclerview.provider.BannerItemProvider;
import org.lym.sourcecodeparse.source.parse.recyclerview.provider.GoodsGirdItemProvider;
import org.lym.sourcecodeparse.source.parse.recyclerview.provider.GuessItemProvider;
import org.lym.sourcecodeparse.source.parse.recyclerview.provider.NewsItemProvider;

import java.util.List;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class MultipleAdapter extends MultipleItemRvAdapter<MultipleItemEntity, BaseViewHolder> {
    public MultipleAdapter(@Nullable List<MultipleItemEntity> data) {
        super(data);
        finishInitialize();
    }

    @Override
    protected int getViewType(MultipleItemEntity multiItemEntity) {
        return multiItemEntity.getItemType();
    }

    @Override
    public void registerItemProvider() {
        mProviderDelegate.registerProvider(new BannerItemProvider());
        mProviderDelegate.registerProvider(new GoodsGirdItemProvider());
        mProviderDelegate.registerProvider(new GuessItemProvider());
        mProviderDelegate.registerProvider(new NewsItemProvider());
    }
}
