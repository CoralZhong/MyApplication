package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 16-5-13.
 */
public class Ball extends View implements View.OnTouchListener{
    int x=540;
    int y=300;
    int left=440;
    int right=700;
    Timer t;
    int xx=(int)(Math.random()*40-20);
    int yy=(int)(Math.random()*40-20);



    public Ball(Context context) {
        super(context);

    }

    public Ball(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    Handler h=new Handler(){
        boolean flag=false;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==0x111){
                if(x<20){
                    xx=-xx;
                    }else if(x>1060) {
                    xx = -xx;
                }else if(y<20){
                    yy=-yy;
                }else if(y>=1300){
                    if(x>left&&x<right){
                        yy=-yy;
                    }
                    else{
                        flag=true;
                    }


                }

                if (flag){
                    x=540;
                    y=300;
                }else{
                x+=xx;
                y+=yy;}
                invalidate();
            }


        }
    };

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        DisplayMetrics dm=new DisplayMetrics();
//        int w=dm.widthPixels;
//        int h=dm.heightPixels;
//        int d=dm.densityDpi;
        Paint p=new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(50);
        p.setColor(Color.GREEN);
        canvas.drawCircle(x,y,50,p);
        canvas.drawRect(left,1300,right,1350,p);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int hx= (int) event.getX();
        boolean timer=true;
        if(x==540){
            if(timer){
                t=new Timer();
                timer=false;
            }

            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    Message m=new Message();
                    m.what=0x111;
                    h.sendMessage(m);

                }
            },100,50);
        }

        left=hx-150;
        right=hx+150;
        invalidate();
        return false;
    }
}
