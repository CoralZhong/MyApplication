package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Administrator on 2016/6/2.
 */
public class QQlogin extends Activity {
    EditText et1;
    EditText et2;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqlogin);
        sp = getSharedPreferences("login",MODE_PRIVATE);
        editor=sp.edit();
        cb= (CheckBox) findViewById(R.id.autologin);
        String s=sp.getString("username","000");
        if(!s.equals("000")){
            Intent i=new Intent(this,QQlogin2.class);
            startActivity(i);

        }
    }

    public void login(View view) {
        if(cb.isChecked()){
            et1 = (EditText) findViewById(R.id.username);
            et2 = (EditText) findViewById(R.id.userpw);
            String username = et1.getText().toString();
            String userpw = et2.getText().toString();
            editor.putString("username",username);
            editor.putString("userpw",userpw);
            editor.commit();

        }

        Intent i=new Intent(this,QQlogin2.class);
        startActivity(i);



    }
    }

