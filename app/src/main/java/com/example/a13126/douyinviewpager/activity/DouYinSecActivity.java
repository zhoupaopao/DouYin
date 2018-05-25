package com.example.a13126.douyinviewpager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a13126.douyinviewpager.R;
import com.example.a13126.douyinviewpager.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13126 on 2018/5/22.
 */

public class DouYinSecActivity extends Activity {
    EditText et_news;
    Button save;
    Button submit;
    ListView newslist;
    List<String>lastlist;
    ListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        首先是用户输入文本，然后输完一条之后点击添加，我们就获取到这个信息，放到一个数组里面，并且将他呈现在下方的列表中，列表需要有个删除按钮，从数组中删除指定的数据
        setContentView(R.layout.activity_douyusec);
        initView();
        initListener();
    }

    private void initListener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String news=et_news.getText().toString().trim();
                et_news.setText("");
                if(news.equals("")){
                    Toast.makeText(DouYinSecActivity.this,"请信息不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    lastlist.add(news);
                    adapter.notifyDataSetChanged();
                    setListViewHeightBasedOnChildren(newslist);
                }

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(DouYinSecActivity.this, DouYinFirstActivity.class);
                intent.putStringArrayListExtra("lastlist", (ArrayList<String>) lastlist);
                startActivity(intent);
            }
        });
         adapter=new ListAdapter(DouYinSecActivity.this,lastlist,newslist);
        newslist.setAdapter(adapter);
    }

    private void initView() {
        et_news=findViewById(R.id.et_news);
        save=findViewById(R.id.save);
        submit=findViewById(R.id.submit);
        newslist=findViewById(R.id.newslist);
        lastlist=new ArrayList<>();
    }
    //这个设置列表固定高度的方法完全可行
    public void setListViewHeightBasedOnChildren(ListView listView) {
        if (listView == null) {
            return;
        }
        ListAdapter listAdapter = (ListAdapter) listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
