package org.lym.sourcecodeparse.source.parse.recyclerview;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.lym.sourcecodeparse.R;
import org.lym.sourcecodeparse.source.parse.activity.BaseActivity;
import org.lym.sourcecodeparse.source.parse.divider.FlexibleDividerDecoration;
import org.lym.sourcecodeparse.source.parse.divider.HorizontalDividerItemDecoration;
import org.lym.sourcecodeparse.source.parse.divider.VerticalDividerItemDecoration;
import org.lym.sourcecodeparse.source.parse.recyclerview.adapter.MultipleAdapter;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.DataServer;
import org.lym.sourcecodeparse.source.parse.recyclerview.data.MultipleItemEntity;
import org.lym.sourcecodeparse.utils.ToastUtils;

import java.util.List;

/**
 * doc recyclerView 复杂布局
 *
 * @author yaoming.li
 * @since 2018/5/12
 */
public class MultipleActivity extends BaseActivity {
    private TextView mRvIndex, mRvCount;
    private ImageView mIvScrollToTop;
    private RecyclerView mRv;
    private MultipleAdapter adapter;
    private SmartRefreshLayout mSmartRefresh;
    private LinearLayout mLinearIndex;
    private LinearLayout mLinearScrollTopIndex;

    @Override
    protected int getLayoutId() {
        return R.layout.module_multiple_activity;
    }

    @Override
    protected void initView() {
        mRvIndex = findViewById(R.id.tv_index_text);
        mRvCount = findViewById(R.id.tv_total_text);
        mIvScrollToTop = findViewById(R.id.iv_list_top);
        mRv = findViewById(R.id.rv_list);
        mSmartRefresh = findViewById(R.id.smart_refresh);
        mLinearIndex = findViewById(R.id.layout_index_relay);
        mLinearScrollTopIndex = findViewById(R.id.liner_list_index);
        initRvAndAdapter();
        initSmartRefresh();
    }

    private void initSmartRefresh() {
        mSmartRefresh.setRefreshHeader(new ClassicsHeader(this));
        mSmartRefresh.setEnableLoadMore(false);
    }

    private void initRvAndAdapter() {
        mRv.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRv.setLayoutManager(manager);
        List<MultipleItemEntity> mList = DataServer.getMultipleData(this);
        adapter = new MultipleAdapter(mList);
        adapter.setPreLoadNumber(8);
        mRv.setAdapter(adapter);
        mRv.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this).marginProvider(new HorizontalDividerItemDecoration.MarginProvider() {
            @Override
            public int dividerLeftMargin(int position, RecyclerView parent) {
                return 30;
            }

            @Override
            public int dividerRightMargin(int position, RecyclerView parent) {
                return 30;
            }
        }).sizeProvider(new FlexibleDividerDecoration.SizeProvider() {
            @Override
            public int dividerSize(int position, RecyclerView parent) {
                return position == 0 || position == 6 || position == 7 || position == 5 || position == 8 || position == parent.getLayoutManager().getItemCount() - 2 || position == parent.getLayoutManager().getItemCount()-3? 0 : 20;
            }
        }).color(Color.parseColor("#E7E7E7")).build());
        mRv.addItemDecoration(new VerticalDividerItemDecoration.Builder(this).sizeProvider(new FlexibleDividerDecoration.SizeProvider() {
            @Override
            public int dividerSize(int position, RecyclerView parent) {
                return 20;
            }
        }).color(Color.parseColor("#E7E7E7")).build());
        adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return adapter.getData().get(position).getSpanCount();
            }
        });
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (adapter.getData().size() >= 60) {
                    adapter.loadMoreEnd();
                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            adapter.addData(DataServer.getListData());
                            adapter.loadMoreComplete();
                        }
                    }, 200);
                }
            }
        }, mRv);
    }

    private int getListSize() {
        return adapter.getData().size();
    }

    private int getHeaderSize() {
        return getListSize() - DataServer.getNewsListCount(adapter.getData()) - 1;
    }

    private void changeRvIndex(int position) {
        if (position > getHeaderSize()) {
            mRvCount.setText(String.valueOf(getListSize()));
            mRvIndex.setText(String.valueOf(position - getHeaderSize()));
            mLinearIndex.setVisibility(View.VISIBLE);
            mIvScrollToTop.setVisibility(View.GONE);
            mLinearScrollTopIndex.setVisibility(View.VISIBLE);
        } else {
            mLinearScrollTopIndex.setVisibility(View.GONE);
        }
    }

    @Override
    protected boolean topIsImage() {
        return true;
    }

    @Override
    protected void bindListener() {
        mIvScrollToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRv.smoothScrollToPosition(0);
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                int viewId = view.getId();
                switch (viewId) {
                    case R.id.multiple_guess_you_like_tv:
                        ToastUtils.showToast("猜你喜欢");
                        break;
                    default:
                        break;
                }
            }
        });
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    //显示返回顶部按钮
                    mIvScrollToTop.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastPosition = layoutManager.findLastVisibleItemPosition();
                changeRvIndex(lastPosition);
            }
        });
        mSmartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.setNewData(DataServer.getMultipleData(MultipleActivity.this));
                        mSmartRefresh.finishRefresh(true);
                    }
                }, 800);
            }
        });
    }
}
