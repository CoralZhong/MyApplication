package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/16.
 */
public class CookDetails extends Activity{
    Bitmap bm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookdetails);
        Bundle b=getIntent().getBundleExtra("a");
        Map<String,String> m= (Map<String, String>) b.getSerializable("info");
        ImageView iv= (ImageView) findViewById(R.id.image);
        TextView tv1= (TextView) findViewById(R.id.name);
        TextView tv2= (TextView) findViewById(R.id.info);
        try {
            final URL url = new URL(m.get("img"));

            (new Thread(){
                @Override
                public void run() {
                    try {
                        bm= BitmapFactory.decodeStream(url.openStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            iv.setImageBitmap(bm);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        tv1.setText("食材："+m.get("food"));
        tv2.setText("步骤："+m.get("message"));
    }


}
