package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-18.
 */
public class Message60seconds extends BaseActivity {
    Button b;
    Timer t;

    @Override
    void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.message60seconds);
        b= (Button) findViewById(R.id.sendmsg);
    }

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                b.setText("获取验证短信");
                b.setEnabled(true);
                t.cancel();
            }else{
                b.setText(msg.what+"s后重新获取");
            }
        }
    };

    public void  sendmsg(View view){
        b.setEnabled(false);
        b.setText("获取中...");
        t=new Timer();
        t.schedule(new TimerTask() {
            int time=60;
            @Override
            public void run() {
                Message m=new Message();
                m.what=time--;
                h.sendMessage(m);
            }
        },100,1000);



    }
}


