package org.lym.sourcecodeparse.source.parse.recyclerview.data;

import android.content.Context;

import org.lym.sourcecodeparse.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class DataServer {
    public static List<MultipleItemEntity> getMultipleData(Context context) {
        List<MultipleItemEntity> list = new ArrayList<>();
        List<String> mArrays = Arrays.asList(context.getResources().getStringArray(R.array.banner));
        list.add(new BannerModel(mArrays));
        list.add(new GridClassifyModel(R.mipmap.icon_one, "家用"));
        list.add(new GridClassifyModel(R.mipmap.icon_two, "家电"));
        list.add(new GridClassifyModel(R.mipmap.icon_three, "菜刀"));
        list.add(new GridClassifyModel(R.mipmap.icon_four, "菜板"));
        list.add(new GridClassifyModel(R.mipmap.icon_five, "拖把"));
        list.add(new GridClassifyModel(R.mipmap.icon_six, "扫把"));
        list.add(new GridClassifyModel(R.mipmap.icon_seven, "马桶"));
        list.add(new GridClassifyModel(R.mipmap.icon_eight, "浴头"));
        list.add(new GuessModel(context.getString(R.string.guess_you_like)));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/230363a700cc4986af1c2382735fc12820180512160722.jpeg", "听说罂粟治疗腹泻 老人种了4270株", "现代快报", "2018-05-12 21:21:26"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/37f3497828914ea9b87d99cb00eb3bb620180511195035.jpeg", "习近平向汶川地震十周年国际研讨会致信", "新华网", "2018-05-12 13:12:22"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/68f95e3e27ea4377b2fa28d12ab16a9c20180512201758.png", "网友忆十年前地震:聊天发现一大批同学头像全黑了", "新京报", "2018-05-12 20:24:06"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/4b813f558a6a442b9f9bd5df4e65e91e20180512192228.jpeg", "空姐打顺风车遇害 4人擅自传播命案现场照片被刑拘", "平安郑州", "2018-05-12 19:33:51"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/057b5327f27849b88489738d0391fad520180512180259.png", "空姐遇害案详情公布:嫌犯行凶后注销滴滴 当晚跳河", "北京青年报", "2018-05-12 18:30:53"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/0d1e3760e0c842bd9a13e5386c3964d920180512164118.png", "缅甸边境爆发冲突 1枚疑似火箭炮落入云南境内爆炸", "海外网", "2018-05-12 19:26:17"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/570ce40f0b8e47b98ccf35414ebbfe3a20180512170842.png", "\"空姐打车遇害案\"嫌犯之父:要补偿人家 但现在没钱", "新京报", "2018-05-12 19:38:51"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/8c630661bc6c44c1a7c6d83505909a9d20180512173008.jpeg", "云南通报\"村民私挖冻肉\"事件:已抓获犯罪嫌疑人7人", "人民日报", "2018-05-12 20:18:21"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/88b0bd79c4554d4091e158a1493be35e20180512211006.png", "9省部级领导职务调整 最年轻省级女常委异地任职", "政事儿", "2018-05-12 21:12:06"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/c3bc098aa1ef4a59af932c93316a1e3620180512210743.png", "近日，冯先生和郑先生两位奶爸给老婆送上一份特殊礼物：他们戴上重达8斤的硅胶“孕肚”，拖地、捡东西、挤公交、体验生产疼痛等，用一天时间体验了从怀孕到生产的过程。“", "重庆晚报", "2018-05-12 21:14:40"));
        return list;
    }

    public static List<MultipleItemEntity> getListData() {
        List<MultipleItemEntity> list = new ArrayList<>();
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/230363a700cc4986af1c2382735fc12820180512160722.jpeg", "听说罂粟治疗腹泻 老人种了4270株", "现代快报", "2018-05-12 21:21:26"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/37f3497828914ea9b87d99cb00eb3bb620180511195035.jpeg", "习近平向汶川地震十周年国际研讨会致信", "新华网", "2018-05-12 13:12:22"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/68f95e3e27ea4377b2fa28d12ab16a9c20180512201758.png", "网友忆十年前地震:聊天发现一大批同学头像全黑了", "新京报", "2018-05-12 20:24:06"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/4b813f558a6a442b9f9bd5df4e65e91e20180512192228.jpeg", "空姐打顺风车遇害 4人擅自传播命案现场照片被刑拘", "平安郑州", "2018-05-12 19:33:51"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/057b5327f27849b88489738d0391fad520180512180259.png", "空姐遇害案详情公布:嫌犯行凶后注销滴滴 当晚跳河", "北京青年报", "2018-05-12 18:30:53"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/0d1e3760e0c842bd9a13e5386c3964d920180512164118.png", "缅甸边境爆发冲突 1枚疑似火箭炮落入云南境内爆炸", "海外网", "2018-05-12 19:26:17"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/570ce40f0b8e47b98ccf35414ebbfe3a20180512170842.png", "\"空姐打车遇害案\"嫌犯之父:要补偿人家 但现在没钱", "新京报", "2018-05-12 19:38:51"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/8c630661bc6c44c1a7c6d83505909a9d20180512173008.jpeg", "云南通报\"村民私挖冻肉\"事件:已抓获犯罪嫌疑人7人", "人民日报", "2018-05-12 20:18:21"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/88b0bd79c4554d4091e158a1493be35e20180512211006.png", "9省部级领导职务调整 最年轻省级女常委异地任职", "政事儿", "2018-05-12 21:12:06"));
        list.add(new NewsModel("http://cms-bucket.nosdn.127.net/c3bc098aa1ef4a59af932c93316a1e3620180512210743.png", "近日，冯先生和郑先生两位奶爸给老婆送上一份特殊礼物：他们戴上重达8斤的硅胶“孕肚”，拖地、捡东西、挤公交、体验生产疼痛等，用一天时间体验了从怀孕到生产的过程。“", "重庆晚报", "2018-05-12 21:14:40"));
        return list;
    }

    public static int getNewsListCount(List<MultipleItemEntity> list) {
        int count = 0;
        for (MultipleItemEntity entity : list) {
            if (entity instanceof NewsModel) {
                count++;
            }
        }
        return count;
    }
}
