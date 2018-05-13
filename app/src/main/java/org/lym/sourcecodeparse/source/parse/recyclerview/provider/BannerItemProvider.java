package org.lym.sourcecodeparse.source.parse.recyclerview.provider;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.BannerModel;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;
import org.lym.sourcecodeparse.utils.ToastUtils;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class BannerItemProvider extends BaseItemProvider<BannerModel, BaseViewHolder> {
    @Override
    public int viewType() {
        return MultipleItemEntity.BANNER_ITEM;
    }

    @Override
    public int layout() {
        return R.layout.rv_multiple_item_banner;
    }

    @Override
    public void convert(BaseViewHolder helper, BannerModel data, int position) {
        Banner banner = helper.getView(R.id.rv_multiple_item_banner);
        banner.setImages(data.getBanner());
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtils.showToast("我是第" + position + "个广告位");
            }
        });
        banner.start();

    }
}
