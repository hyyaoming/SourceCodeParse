package org.lym.sourcecodeparse.source.parse.recyclerview.data;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class GridClassifyModel implements MultipleItemEntity {
    private int mRes;
    private String mTitle;

    public String getTitle() {
        return mTitle;
    }

    public GridClassifyModel(int res, String title) {
        this.mRes = res;
        this.mTitle = title;
    }

    public int getRes() {
        return mRes;
    }

    @Override
    public int getSpanCount() {
        return 1;
    }

    @Override
    public int getItemType() {
        return GRID_CLASSIFY_ITEM;
    }
}
