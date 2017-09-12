package com.jiyun.day01_homework.okhttp;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dell on 2017/9/11.
 */

public class OkHttpUtils {
    private static OkHttpUtils utils;
    private OkHttpClient client;
    private OkHttpUtils(){
        client=new OkHttpClient();
    }
    public static synchronized OkHttpUtils getInstance(){
        if(utils==null){
            utils=new OkHttpUtils();
        }
        return utils;
    }
    public void sendGET(String url, Callback callback){
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(callback);
    }
}
