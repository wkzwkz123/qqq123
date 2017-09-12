package com.jiyun.day01_homework.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.day01_homework.R;
import com.youth.banner.Banner;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment2 extends Fragment {


    private Banner banner;
    private TextView tv;

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        tv = (TextView) view.findViewById(R.id.tv);
    }
}
