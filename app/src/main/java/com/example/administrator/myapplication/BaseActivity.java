package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/5/26.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.baseactivity);
        initContentView(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setBackgroundColor(0xf2a737);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("小九的作业合集");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = new MenuInflater(this);
        inf.inflate(R.menu.baseactivity,menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId())
        {
            case android.R.id.home:
                Intent intent=new Intent(this,main.class);
                startActivity(intent);
                break;
            case R.id.normal_btn:Toast.makeText(BaseActivity.this, "仲小九", Toast.LENGTH_SHORT).show();break;
        }
        return super.onOptionsItemSelected(item);
    }
    abstract void initContentView(Bundle savedInstanceState);
}
