package com.jiyun.day01_homework.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.day01_homework.Bean.Bean;
import com.jiyun.day01_homework.Main2Activity;
import com.jiyun.day01_homework.R;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private Banner banner;
    private TextView tv;
    private Main2Activity activity;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        activity = (Main2Activity) getActivity();
        initData();
        return view;
    }

    private void initData() {
        activity.blankFragment.setOnClicker(new BlankFragment.OnClicker() {
            @Override
            public void sendString(ArrayList<Bean.DataBean> mList, int i) {
                Toast.makeText(activity, ""+i, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        tv = (TextView) view.findViewById(R.id.tv);
    }
}
