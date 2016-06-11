package com.example.administrator.myapplication;

import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

/**
 * Created by TOSHIBA on 2016/6/11.
 */
public class GestureActivity2 extends BaseActivity {
    GestureOverlayView gestureOverlayView;
    GestureLibrary gestLib;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.gestureactivity2);


        gestLib = GestureLibraries.fromPrivateFile(this, "mygestures");
        if (!gestLib.load()) {
            Toast.makeText(GestureActivity2.this, "手势库加载失败！", Toast.LENGTH_SHORT).show();
        }


        gestureOverlayView = (GestureOverlayView) findViewById(R.id.gestureView);
        gestureOverlayView.setGestureColor(Color.GREEN);
        gestureOverlayView.setGestureStrokeWidth(5);


        gestureOverlayView.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                boolean flag = false;
                List<Prediction> list = gestLib.recognize(gesture);
                for (Prediction p : list) {
                    if (p.score > 2.0) {
                        Toast.makeText(GestureActivity2.this, "找到匹配手势！" + p.name + "<<<" + p.score, Toast.LENGTH_LONG).show();
                        flag = true;
                        Intent i = new Intent();
                        i.setAction(Intent.ACTION_MAIN);
                        i.addCategory(Intent.CATEGORY_HOME);
                        startActivity(i);
                        break;
                    }
                }
                if (!flag) {
                    Toast.makeText(GestureActivity2.this, "没找到匹配手势！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

