package org.lym.sourcecodeparse.source.parse.recyclerview.data;

import java.util.List;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class BannerModel implements MultipleItemEntity {
    private List<String> mBanner;

    public List<String> getBanner() {
        return mBanner;
    }

    public BannerModel(List<String> banner) {
        this.mBanner = banner;
    }

    @Override
    public int getItemType() {
        return BANNER_ITEM;
    }

    @Override
    public int getSpanCount() {
        return 4;
    }
}
