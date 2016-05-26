package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 16-5-13.
 */
public class BALLSHOW extends Activity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Ball h=new Ball(this);
        h.setOnTouchListener(h);
        setContentView(h);
    }

}
