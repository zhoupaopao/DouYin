package com.example.a13126.douyinviewpager.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a13126.douyinviewpager.R;
import com.example.a13126.douyinviewpager.activity.DouYinSecActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13126 on 2018/5/23.
 */

public class ListAdapter extends BaseAdapter {
    private  List<String>newlist;
    private LayoutInflater layoutInflater;
    private ListView listView;
    private DouYinSecActivity mcontent;
    //其实这里可以用recycleView，单行删除，以后改进

    public ListAdapter(DouYinSecActivity mcontent, List<String> aaa, ListView listView){
        this.newlist=aaa;
        this.mcontent=mcontent;
        this.layoutInflater = LayoutInflater.from(mcontent);
        this.listView=listView;
    }
    @Override
    public int getCount() {
        return newlist.size();
    }

    @Override
    public Object getItem(int i) {
        return newlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        Log.i("getView: ", position+"");
        ViewHolder viewHolder;
        if(view==null){
            view=layoutInflater.inflate(R.layout.list_item,null);
            viewHolder=new ViewHolder();
            viewHolder.tv_news=view.findViewById(R.id.tv_shuju);
            viewHolder.delete=view.findViewById(R.id.delete);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tv_news.setText(newlist.get(position));
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newlist.remove(position);
                //刷新列表
                notifyDataSetChanged();
                mcontent.setListViewHeightBasedOnChildren(listView);
            }
        });
        return view;
    }

    private static class ViewHolder{
        private TextView tv_news;
        private ImageView delete;
    }
}
