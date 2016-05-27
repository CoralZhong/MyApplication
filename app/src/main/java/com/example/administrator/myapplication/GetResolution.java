package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 16-5-23.
 */
public class GetResolution extends BaseActivity {

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.getresolution);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        float density=dm.density;
        TextView tv1= (TextView) findViewById(R.id.width);
        TextView tv2= (TextView) findViewById(R.id.height);
        TextView tv3= (TextView) findViewById(R.id.dpi);
        tv1.setText("您的屏幕宽为："+width);
        tv2.setText("您的屏幕高为："+height);
        tv3.setText("您的屏幕密度："+density);



    }





}
