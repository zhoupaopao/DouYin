package com.example.a13126.douyinviewpager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.a13126.douyinviewpager.Fragment.FirstFragment;
import com.example.a13126.douyinviewpager.R;
import com.example.a13126.douyinviewpager.adapter.PagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 13126 on 2018/5/21.
 */
//这个抖音的功能很简单，只是将不同的字居中显示，可以用于文本的描述，一步步的来，统一添加。

public class DouYinFirstActivity extends FragmentActivity {
    private ViewPager viewPager;
    private ArrayList<String>lastlist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_douyinfirst);
        initView();
    }

    private void initView() {
        viewPager=findViewById(R.id.vp);
        List<Fragment>fragmentList=new ArrayList<>();
        fragmentList.add(new  FirstFragment("123"));
        fragmentList.add(new  FirstFragment("123a"));
        fragmentList.add(new  FirstFragment("1234"));

        lastlist=getIntent().getStringArrayListExtra("lastlist");
        if(lastlist!=null){
            //有数组参数
            fragmentList.clear();
            for(int i=0;i<lastlist.size();i++){
                fragmentList.add(new  FirstFragment(lastlist.get(i)));
            }

        }
        PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(adapter);
//        viewPager.setAdapter();
    }
}
