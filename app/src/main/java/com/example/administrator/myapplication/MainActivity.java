package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickmybutton(View view){
        Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd hh:mm;ss");
        String time=sd.format(d);
        TextView tv= (TextView) findViewById(R.id.textView);
        tv.setText(time);
    }
}
