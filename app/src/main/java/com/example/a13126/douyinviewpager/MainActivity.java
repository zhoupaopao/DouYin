package com.example.a13126.douyinviewpager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.fastjson.JSONObject;
import com.example.a13126.douyinviewpager.activity.DouYinFirstActivity;
import com.example.a13126.douyinviewpager.activity.DouYinSecActivity;

import cn.finalteam.okhttpfinal.HttpCycleContext;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.JsonHttpRequestCallback;
import cn.finalteam.okhttpfinal.RequestParams;




//        准备做个能够将定位写入文本里面的app，等到有无线网的时候上传。
//每半小时获取一次定位，这里可以启动一个服务，30分钟执行一次，将获取的经纬度存在文件当中，每一小时请求一下当前状态，是否是无线网状态，是的话就上传这个文件。


//类似年轮的app，需要每天添加一张图片，最好如果今天没有添加可以发送个广播推送一下。
//实现原理，添加一张图片，然后填上现在的体重，上传到后台，返回一个图片的url，最好这个图片能做一下水印，上面有体重，然后我把这个数据存放在本地，在列表中展示，如果sp里面存放不了那么多数据的话就存放在一个文件里面
public class MainActivity extends AppCompatActivity implements View.OnClickListener,HttpCycleContext {
    protected final String HTTP_TASK_KEY = "HttpTaskKey_" + hashCode();
    private Button douyin_first;
    private Button douyin_sec;
    private Button text_online;
    private Context context=null;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        douyin_first=findViewById(R.id.douyin_first);
        douyin_sec=findViewById(R.id.douyin_sec);
        text_online=findViewById(R.id.text_online);
        intent=new Intent();
        context=this;
    }

    private void initListener() {
        douyin_first.setOnClickListener(this);
        douyin_sec.setOnClickListener(this);
        text_online.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.douyin_first:

                intent.setClass(this, DouYinFirstActivity.class);
                startActivity(intent);
                break;
            case R.id.douyin_sec:
                intent.setClass(this, DouYinSecActivity.class);
                startActivity(intent);
                break;
            case R.id.text_online:

//                String path = context.getCacheDir().getPath();
//                http://m1api.chetxt.com:8083/Customer.asmx/Jsonp_GetLogin
                RequestParams params=new RequestParams(MainActivity.this);
                params.addFormDataPart("username","test");
                params.addFormDataPart("password","654654");
                HttpRequest.post("http://m1api.chetxt.com:8083/Customer.asmx/Jsonp_GetLogin",params,new JsonHttpRequestCallback(){
                    @Override
                    protected void onSuccess(JSONObject jsonObject) {
                        super.onSuccess(jsonObject);
                        Log.i("onSuccess: ", jsonObject.toString());
                    }

                    @Override
                    public void onFailure(int errorCode, String msg) {
                        super.onFailure(errorCode, msg);
                    }
                });
                break;

        }
    }

    @Override
    public String getHttpTaskKey() {
        return HTTP_TASK_KEY;
    }
}
