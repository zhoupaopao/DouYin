package com.example.a13126.douyinviewpager.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a13126.douyinviewpager.R;

/**
 * Created by 13126 on 2018/5/22.
 */

@SuppressLint("ValidFragment")
public class FirstFragment extends Fragment {
    TextView tv_first;
    String strfirst="";
    @SuppressLint("ValidFragment")
    public FirstFragment(String sdsd) {
        this.strfirst=sdsd;

    }

//    public static FirstFragment firstFragment(String sdsd) {
//        FirstFragment firstFragment=new FirstFragment();
//        strfirst=sdsd;
//        return firstFragment;
//    }

//    public void  FirstFragment(String asdasd){
//        strfirst= asdasd;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        tv_first=view.findViewById(R.id.tv_first);
        tv_first.setText(strfirst);
        return view;
    }
}
