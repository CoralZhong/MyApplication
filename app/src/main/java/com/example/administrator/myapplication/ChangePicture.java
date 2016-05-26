package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 16-5-17.
 */
public class ChangePicture extends Activity{

    public int[] a = {R.drawable.icon_11,R.drawable.icon_28,R.drawable.icon_30,R.drawable.icon_33,R.drawable.icon_37};
    public int i = 0;
    int alpha = 255;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepicture);
        imgView= (ImageView) findViewById(R.id.pic);
        imgView.setImageResource(a[0]);

    }
    public void last(View view){
        if(i==0){
            i=4;
        }else{
            --i;
        }
        imgView.setImageResource(a[i]);

    }
    public void next(View view){
        if(i==4){
            i=0;
        }else{
            ++i;
        }
        imgView.setImageResource(a[i]);

    }
    public void tjia(View view){
        alpha+=10;
        if(alpha > 255){
            imgView.setImageAlpha(255);
            alpha = 255;
        }else{
            imgView.setImageAlpha(alpha);
        }

    }
    public void tjian(View view){
        alpha-=10;
        if(alpha < 0){
            imgView.setImageAlpha(0);
            alpha=0;
        }else{
            imgView.setImageAlpha(alpha);
        }
    }

}
