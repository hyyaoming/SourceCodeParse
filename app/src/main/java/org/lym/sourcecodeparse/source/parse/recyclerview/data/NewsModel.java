package org.lym.sourcecodeparse.source.parse.recyclerview.data;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class NewsModel implements MultipleItemEntity {
    private String mUrl;
    private String mTitle;
    private String mSource;
    private String mTime;

    public NewsModel(String url, String title, String source, String time) {
        this.mUrl = url;
        this.mTitle = title;
        this.mSource = source;
        this.mTime = time;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSource() {
        return mSource;
    }

    public String getTime() {
        return mTime;
    }


    @Override
    public int getSpanCount() {
        return 4;
    }

    @Override
    public int getItemType() {
        return NEWS_LIST_ITEM;
    }
}
