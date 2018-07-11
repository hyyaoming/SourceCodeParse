package org.lym.sourcecodeparse.source.parse.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import org.lym.sourcecodeparse.R;

/**
 * doc
 *
 * @author yaoming.li
 * @since 2018/6/3
 */
public class TabActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setContentView(R.layout.module_activity_tab);
        TabLayout mTabLayout = findViewById(R.id.tabLayout);
        final ViewPager mPager = findViewById(R.id.vp);
        mTabLayout.setupWithViewPager(mPager);
        mPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return TabFragment.instance(ImageUrl.IMAGE_ONE);
                } else if (position == 1) {
                    return TabFragment.instance(ImageUrl.IMAGE_TWO);
                }
                return TabFragment.instance(ImageUrl.IMAGE_THREE);
            }


            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "首页";
                } else if (position == 1) {
                    return "中页";
                } else {
                    return "尾页";
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
