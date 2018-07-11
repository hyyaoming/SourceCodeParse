package org.lym.sourcecodeparse.source.parse.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * doc  基类fragment,赖加载数据的fragment
 *
 * @author yaoming.li
 * @since 2018/6/3
 */
public abstract class BaseFragment extends Fragment {
    protected View mRootView;
    protected Context mContext;
    private boolean mLoad = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getInflaterId(), null);
            initView();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (null != parent) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getUserVisibleHint() && !mLoad && mRootView != null) {
            mLoad = true;
            lazyLoadData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisible() && isVisibleToUser && mRootView != null && !mLoad) {
            mLoad = true;
            lazyLoadData();
        } else {
            super.setUserVisibleHint(isVisibleToUser);
        }
    }

    protected abstract void lazyLoadData();

    protected abstract void initView();

    protected abstract int getInflaterId();

}
