package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ViewSwitcher;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Switch3seconds extends BaseActivity {
    ViewSwitcher vs;
    Timer t;
    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            vs.showNext();
        }
    };
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.switch3seconds);
        vs= (ViewSwitcher) findViewById(R.id.viewswitcher);
        View v1=View.inflate(this,R.layout.apicture,null);
        View v2=View.inflate(this,R.layout.qqlogin,null);
        View v3=View.inflate(this,R.layout.bomb,null);
        vs.addView(v1);
        vs.addView(v2);
        t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Message m=new Message();
                m.what=0;
                h.sendMessage(m);

            }
        },800,3000);

    }
}
