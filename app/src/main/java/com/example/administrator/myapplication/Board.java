package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Board extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PaintBoard pb=new PaintBoard(this);
        pb.setOnTouchListener(pb);
        setContentView(pb);

    }
}
