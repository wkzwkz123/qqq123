package com.jiyun.day01_homework;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.day01_homework.Adapert.PagerAdapert;
import com.jiyun.day01_homework.fragment.BlankFragment;
import com.jiyun.day01_homework.fragment.BlankFragment2;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    public ViewPager vp;
    public BlankFragment blankFragment;
    private BlankFragment2 blankFragment2;
    private Handler handler=new Handler();
    private int cuttent=0;
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            cuttent+=5;
            if(cuttent>100){
                dialog.dismiss();
            }else{
                handler.postDelayed(runnable,300);
                dialog.setProgress(cuttent);
            }

        }
    };
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dialog = new ProgressDialog(this);
        dialog.setTitle("请稍等。。。。。");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        handler.postDelayed(runnable,300);
        dialog.setMax(100);
        dialog.show();
        initView();
        initData();
    }

    private void initData() {
        ArrayList<Fragment> list=new ArrayList<>();
        blankFragment = new BlankFragment();
        list.add(blankFragment);
        blankFragment2 = new BlankFragment2();
        list.add(blankFragment2);
        PagerAdapert adapert=new PagerAdapert(getSupportFragmentManager(),list);
        vp.setAdapter(adapert);
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
