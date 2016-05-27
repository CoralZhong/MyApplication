package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Context;
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
    List<heartbean> list=new ArrayList<heartbean>();
    public heart(Context context) {
        super(context);
    }

    @Override

    public boolean onTouch(View v, MotionEvent event) {
        int color=(int)(0xff000000+(Math.random()*(0xffffff)));
        px=event.getX();
        py=event.getY();
        //int color=(int)(Math.random()*6+1);
        heartbean hb=new heartbean();
        hb.setX((float) px);
        hb.setY((float)py);
        hb.setColor(color);
        list.add(hb);
        invalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();

        p.setAntiAlias(true);
        p.setStrokeWidth(8);


        double x;
        double y, yy;
//        int color=(int)(Math.random()*6+1);
//        switch (color){
//            case 1: p.setColor(Color.RED);break;
//            case 2: p.setColor(Color.BLUE);break;
//            case 3: p.setColor(Color.GREEN);break;
//            case 4: p.setColor(Color.CYAN);break;
//            case 5: p.setColor(Color.YELLOW);break;
//            case 6: p.setColor(Color.DKGRAY);break;
//            default:p.setColor(Color.BLUE);break;
//
//        }



        for(heartbean hh:list){
            float x1=hh.getX();
            float y1=hh.getY();
            int c=hh.getColor();
//            switch (c){
//                case 1: p.setColor(Color.RED);break;
//                case 2: p.setColor(Color.BLUE);break;
//                case 3: p.setColor(Color.GREEN);break;
//                case 4: p.setColor(Color.CYAN);break;
//                case 5: p.setColor(Color.YELLOW);break;
//                case 6: p.setColor(Color.DKGRAY);break;
//
//            }
            p.setColor(c);
            for ( x= -2; x <= 2; x = x + 0.005) {
                y = (-1) * Math.sqrt(Math.sqrt(x * x) * 2 - (x * x));
                canvas.drawPoint((float)( x * 100 +x1), (float)( y * 100 + y1), p);
                canvas.drawPoint((float)( x * 50 +x1), (float)( y * 50 + y1), p);
                yy = 2.14 * Math.sqrt(Math.sqrt(2) - Math.sqrt(Math.abs(x)));
                canvas.drawPoint((float)( x * 100 + x1), (float)( yy * 100 + y1), p);
                canvas.drawPoint((float)( x * 50 + x1), (float)( yy * 50 + y1), p);

            }

        }






//        double x,y,r;
//        for (int i=0;i<90;i++){
//
//            for (int j=0;j<90;j++){
//                r=Math.PI / 45 * i *(1-Math.sin(Math.PI/45*j))*20;
//                x=r*Math.cos(Math.PI/45*j)*Math.sin(Math.PI/45*j)+320/2;
//                y=-r*Math.sin(Math.PI/45*j)+400/2;
//
//               canvas.drawPoint((float) x,(float) y,p);
//            }
//
//        }

    }

}
