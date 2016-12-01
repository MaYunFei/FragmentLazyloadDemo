package com.yunfei.fragmentlazyloaddemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yunfei on 2016/11/24.
 */

public class ViewPageActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_page_activity);
        viewPager = (ViewPager) findViewById(R.id.vp_main);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }

    public static class MyAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;

        public MyAdapter(FragmentManager fm) {
            super(fm);
            fragmentList = new ArrayList<>();
            fragmentList.add(ViewPageFragment01.newInstance());
            fragmentList.add(ViewPageFragment02.newInstance());
            fragmentList.add(ViewPageFragment03.newInstance());
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
