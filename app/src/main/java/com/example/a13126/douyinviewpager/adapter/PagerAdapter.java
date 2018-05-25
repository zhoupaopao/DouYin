package com.example.a13126.douyinviewpager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 13126 on 2018/5/22.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    List<Fragment>fragmentList;
    public PagerAdapter(FragmentManager fm, List<Fragment>fragmentLists) {
        super(fm);
        fragmentList=fragmentLists;


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
