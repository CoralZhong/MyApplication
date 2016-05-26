package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 16-5-18.
 */
public class Message60seconds extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message60seconds);
}

    public void  sendmsg(View view){
        Button b= (Button) findViewById(R.id.sendmsg);


    }
}


