package org.lym.sourcecodeparse.source.parse.design;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/3/12
 */

public class SuspensionActivity extends AppCompatActivity {

    private RecyclerView mRvList;
    private TabLayout mTabLayout;
    private SmartRefreshLayout mSwipe;
    private AppBarLayout mBarLayout;
    private TextView mTvHead;
    private String[] arr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_activity_design);
        initData();
        initView();
    }

    private void initData() {
        arr = getResources().getStringArray(R.array.design);
    }

    private void initView() {
        mTvHead = findViewById(R.id.tv_head);
        mTvHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SuspensionActivity.this, "我是头部呀", Toast.LENGTH_LONG).show();
            }
        });
        mSwipe = findViewById(R.id.swipe);
        MaterialHeader header  = new MaterialHeader(this);
        header.setPrimaryColors(Color.WHITE);
        header.setShowBezierWave(true);
        mSwipe.setRefreshHeader(header);
        mTabLayout = findViewById(R.id.tab_layout);
        mRvList = findViewById(R.id.rv_list);
        mRvList.setHasFixedSize(true);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        mRvList.setLayoutManager(manager);
        mRvList.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        mRvList.setAdapter(new MyAdapter());
        for (int i = 0; i < 10; i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText("哈哈" + i));
        }
        mSwipe.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(SuspensionActivity.this, "我在刷新呢", Toast.LENGTH_LONG).show();
                mRvList.scrollToPosition(0);
                mSwipe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipe.finishRefresh();
                    }
                }, 1500);
            }
        });
        mBarLayout = findViewById(R.id.appbar);
        mBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    mSwipe.setEnabled(true);
                } else {
                    mSwipe.setEnabled(false);
                }
            }
        });
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(SuspensionActivity.this, "position" + tab.getPosition(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public static void open(Context context) {
        context.startActivity(new Intent(context, SuspensionActivity.class));
    }

    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


        @NonNull
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list, null);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
            holder.mTv.setText(arr[position]);
        }

        @Override
        public int getItemCount() {
            return arr.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView mTv;


            public MyViewHolder(View itemView) {
                super(itemView);
                mTv = itemView.findViewById(R.id.tv_item);
            }
        }
    }
}
