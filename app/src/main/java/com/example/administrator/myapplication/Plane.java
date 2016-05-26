package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 16-5-23.
 */
public class Plane extends View implements View.OnTouchListener{

    public Plane(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Plane(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        Bitmap bm= BitmapFactory.decodeResource(getResources(),R.drawable.airplane);
        canvas.drawBitmap(bm,orax,oray,p);
    }
    float x;
    float y;
    float cx;
    float cy;
    float orax;
    float oray;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float touchx=event.getX();
        float touchy=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                cx=touchx-orax;
                cy=touchy-oray;
            case MotionEvent.ACTION_MOVE:

            case MotionEvent.ACTION_UP:
                orax=touchx-cx;
                oray=touchy-cy;
                invalidate();
                return true;

        }
        return true;
    }
}
