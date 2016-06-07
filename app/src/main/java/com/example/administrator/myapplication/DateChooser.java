package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/7.
 */
public class DateChooser extends Activity {
    EditText et;
    Bundle b;
int year;
    int month;
    int date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datechooser);
        et= (EditText) findViewById(R.id.dateshow);
        if(getIntent().getBundleExtra("data")!=null){
         b=getIntent().getBundleExtra("data");
            year=b.getInt("year");
            month=b.getInt("month")+1;
            date=b.getInt("date");
            et.setText(year+"年"+month+"月"+date+"日");
        }

    }
    public void choosedate(View view){
        Intent i=new Intent(this,DateChooser2.class);
        startActivity(i);

    }
}
