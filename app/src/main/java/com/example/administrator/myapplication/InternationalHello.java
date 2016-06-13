package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/8.
 */
public class InternationalHello extends BaseActivity {
    TextView tv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.internationalhello);
//        tv= (TextView) findViewById(R.id.internationaltxt);
//        tv.setText(R.string.hello);
    }
}
