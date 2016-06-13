package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/2.
 */
public class Advertisement extends BaseActivity {
    int[] imgid={R.drawable.ad1,R.drawable.ad2,R.drawable.ad3};
    AdapterViewFlipper avf;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.advertisement);
        avf= (AdapterViewFlipper) findViewById(R.id.ad);
        BaseAdapter ba=new BaseAdapter() {
            @Override
            public int getCount() {
                return imgid.length;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView iv=new ImageView(Advertisement.this);
                iv.setImageResource(imgid[position]);
                return iv;
            }
        };
        avf.setAdapter(ba);
        avf.startFlipping();

    }
}
