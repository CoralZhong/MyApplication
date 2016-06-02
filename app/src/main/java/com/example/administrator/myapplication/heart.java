package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myapplication.bean.heartbean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 16-5-12.
 */
public class heart extends View implements View.OnTouchListener {
    public double px,py;
    //List<heartbean> list=new ArrayList<heartbean>();
    Bitmap bitmap;
    Canvas tempc;
    public heart(Context context) {
        super(context);
        bitmap=Bitmap.createBitmap(1080,1920, Bitmap.Config.ARGB_8888);
        tempc=new Canvas();
        tempc.setBitmap(bitmap);


    }

    @Override

    public boolean onTouch(View v, MotionEvent event) {
        int color=(int)(0xff000000+(Math.random()*(0xffffff)));
        px=event.getX();
        py=event.getY();
        //int color=(int)(Math.random()*6+1);
        Paint p = new Paint();
        p.setAntiAlias(true);
        p.setStrokeWidth(8);


        double x;
        double y, yy;
            float x1= (float) px;
            float y1= (float) py;
            int c=color;
            p.setColor(c);
            for ( x= -2; x <= 2; x = x + 0.001) {
                y = (-1) * Math.sqrt(Math.sqrt(x * x) * 2 - (x * x));
                tempc.drawPoint((float)( x * 100 +x1), (float)( y * 100 + y1), p);
                tempc.drawPoint((float)( x * 50 +x1), (float)( y * 50 + y1), p);
                yy = 2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x)));
                tempc.drawPoint((float)( x * 100 + x1), (float)( yy * 100 + y1), p);
                tempc.drawPoint((float)( x * 50 + x1), (float)( yy * 50 + y1), p);

            }


        invalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint PP=new Paint();
        canvas.drawBitmap(bitmap,0,0,PP);

    }

}
