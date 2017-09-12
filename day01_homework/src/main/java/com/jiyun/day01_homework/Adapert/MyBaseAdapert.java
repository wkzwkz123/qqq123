package com.jiyun.day01_homework.Adapert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.day01_homework.Bean.Bean;
import com.jiyun.day01_homework.R;

import java.util.ArrayList;

/**
 * Created by dell on 2017/9/11.
 */

public class MyBaseAdapert extends BaseAdapter {
    private ArrayList<Bean.DataBean> list;
    private Context context;

    public MyBaseAdapert(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder=null;
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder=new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getGoods_img()).into(holder.lv_img);
        holder.lv_title.setText(list.get(i).getGoods_name());
        holder.lv_content.setText(list.get(i).getEfficacy());
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView lv_img;
        public TextView lv_title;
        public TextView lv_content;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.lv_img = (ImageView) rootView.findViewById(R.id.lv_img);
            this.lv_title = (TextView) rootView.findViewById(R.id.lv_title);
            this.lv_content = (TextView) rootView.findViewById(R.id.lv_content);
        }

    }
}
