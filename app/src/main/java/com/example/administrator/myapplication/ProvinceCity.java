package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by TOSHIBA on 2016/6/11.
 */
public class ProvinceCity extends BaseActivity {
    TextView tv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.provincecity);
        tv= (TextView) findViewById(R.id.province);
        if(getIntent().getBundleExtra("city")!=null){
            Bundle b=getIntent().getBundleExtra("city");
            tv.setText(b.getString("city"));
        }
    }

         public void choose(View view){
                 Intent i=new Intent(this,City.class);
                 startActivity(i);
             }


}
