package com.yunfei.fragmentlazyloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2016/11/29.
 */

public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tab;
    private ViewPager vp;
    private List<Fragment> fragments;
    private String[] mTitles = new String[]{"01", "02", "03"};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_activity);
        tab = (TabLayout) findViewById(R.id.tab_layout);
        vp = (ViewPager) findViewById(R.id.vp_main);
        fragments = new ArrayList<>();
        fragments.add(ViewPageFragment01.newInstance());
        fragments.add(ViewPageFragment02.newInstance());
        fragments.add(ViewPageFragment03.newInstance());
        vp.setAdapter(new MyAdapter(getSupportFragmentManager(), fragments, mTitles));
        tab.setupWithViewPager(vp);
    }

    static class MyAdapter extends FragmentPagerAdapter {

        private final List<Fragment> data;
        private final String[] titles;

        public MyAdapter(FragmentManager fm, List<Fragment> data, String[] titles) {
            super(fm);
            this.data = data;
            this.titles = titles;
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
