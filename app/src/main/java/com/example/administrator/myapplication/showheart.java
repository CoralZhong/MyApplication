package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 16-5-12.
 */
public class showheart extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        heart h=new heart(this);
        h.setOnTouchListener(h);
        setContentView(h);
    }
}
