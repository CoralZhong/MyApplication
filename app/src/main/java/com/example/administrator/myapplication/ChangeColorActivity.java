package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

/**
 * Created by  on 2016/3/25.
 */
public class ChangeColorActivity extends BaseActivity {
    int[] colors = {0xFFFF0000,0xfff436ea,0xff00aaff,0xff00ff6f,0xffffea00};
    int[] ids = {R.id.a1,R.id.a2,R.id.a3,R.id.a4,R.id.a5};
    int index = 1;


    @Override
    protected void initContentView(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        setContentView(R.layout.changecolor_layout);

        Chronometer c = (Chronometer) findViewById(R.id.clock);
        c.setBase(SystemClock.elapsedRealtime());
        c.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime()-chronometer.getBase())>3*1000){
                    for(int i=0;i<5;i++){
                        TextView t1 = (TextView) findViewById(ids[i]);
                        t1.setBackgroundColor(colors[index++%5]);
                    }
                    index++;
                    chronometer.setBase(SystemClock.elapsedRealtime());
                }
            }
        });
        c.start();
    }
}
