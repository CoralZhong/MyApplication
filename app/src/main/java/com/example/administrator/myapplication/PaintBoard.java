package com.example.administrator.myapplication;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import android.widget.Switch;

/**
 * Created by Administrator on 2016/6/1.
 */
public class PaintBoard extends View implements View.OnTouchListener{
    public double px,py;
    Bitmap bitmap;
    Canvas tempc;
    public PaintBoard(Context context) {
        super(context);
        bitmap=Bitmap.createBitmap(1080,1920, Bitmap.Config.ARGB_8888);
        tempc=new Canvas();
        tempc.setBitmap(bitmap);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        px=event.getX();
        py=event.getY();
        android.graphics.Paint p=new android.graphics.Paint();
        p.setColor(Color.BLUE);
        p.setAntiAlias(true);
        p.setStrokeWidth(8);

        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:tempc.drawPoint((float) px,(float)py,p);
                invalidate();
                break;
        }


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint pp=new Paint();
        canvas.drawBitmap(bitmap,0,0,pp);
    }
}
