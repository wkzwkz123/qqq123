package com.jiyun.day01_homework;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.exit,R.anim.entor);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler.postDelayed(runnable,3000);
    }
}
