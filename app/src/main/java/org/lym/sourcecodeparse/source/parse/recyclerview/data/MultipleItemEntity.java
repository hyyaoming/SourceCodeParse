package org.lym.sourcecodeparse.source.parse.recyclerview.data;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public interface MultipleItemEntity extends MultiItemEntity {
    int BANNER_ITEM = 0x001;
    int GRID_CLASSIFY_ITEM = 0x002;
    int GUESS_YOU_LIKE = 0x003;
    int NEWS_LIST_ITEM = 0x004;

    int getSpanCount();
}
