package org.lym.sourcecodeparse.source.parse.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/6/3
 */
public class TabFragment extends BaseFragment {
    private static final String TAG = "TagFragment";
    private static final String IMAGE_URL = "tab_id";
    private ImageView mIv;


    public static TabFragment instance(String imageUrl) {
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(IMAGE_URL, imageUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void lazyLoadData() {
        if (null != getArguments()) {
            String imageUrl = getArguments().getString(IMAGE_URL);
            Log.e(TAG, imageUrl);
            Glide.with(mContext).setDefaultRequestOptions(getRequestOptions(DefIconFactory.iconDefault()).fitCenter()).asBitmap().load(imageUrl).into(mIv);
        }
    }

    private RequestOptions getRequestOptions(int defaultImage) {
        return new RequestOptions()
                .placeholder(defaultImage) //加载中图片
                .dontAnimate()
                .error(defaultImage) //加载失败图片
                .fallback(defaultImage) //url为空图片
                .priority(Priority.HIGH) //优先级
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
    }

    @Override
    protected void initView() {
        mIv = mRootView.findViewById(R.id.tabIv);
    }

    @Override
    protected int getInflaterId() {
        return R.layout.module_tab_fragment;
    }
}
