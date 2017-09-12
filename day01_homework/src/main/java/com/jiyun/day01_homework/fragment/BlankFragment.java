package com.jiyun.day01_homework.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.jiyun.day01_homework.Adapert.MyBaseAdapert;
import com.jiyun.day01_homework.Bean.Bean;
import com.jiyun.day01_homework.Main2Activity;
import com.jiyun.day01_homework.R;
import com.jiyun.day01_homework.okhttp.OkHttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private Toolbar tool_bar;
    private ListView lv;
    private Main2Activity activity;
    private ArrayList<Bean.DataBean> mList=new ArrayList<>();
    private MyBaseAdapert myBase;
    private OnClicker on;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        activity = (Main2Activity) getActivity();
        initView(view);
        initAdapert();
        initData();
        return view;
    }
    public interface OnClicker{
        void sendString(ArrayList<Bean.DataBean> mList, int i);
    }
    public void setOnClicker(OnClicker on){
        this.on=on;
    }
    private void initData() {
        OkHttpUtils.getInstance().sendGET("http://m.yunifang.com/yunifang/mobile/goods/getall?random=60305&encode=b0358434fda8d7478bfc325b5828b721&category_id=17", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Bean bean = new Gson().fromJson(string, Bean.class);
                final List<Bean.DataBean> data = bean.getData();
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mList.addAll(data);
                        myBase.notifyDataSetChanged();
                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                activity.vp.setCurrentItem(1);
                                on.sendString(mList,i);
                            }
                        });
                    }
                });
            }
        });
    }

    private void initAdapert() {
        myBase = new MyBaseAdapert(mList,activity);
        lv.setAdapter(myBase);
    }

    private void initView(View view) {
        tool_bar = (Toolbar) view.findViewById(R.id.tool_bar);
        activity.setSupportActionBar(tool_bar);
        lv = (ListView) view.findViewById(R.id.lv);
    }
}
