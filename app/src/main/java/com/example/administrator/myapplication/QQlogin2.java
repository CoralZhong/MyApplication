package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

/**
 * Created by Administrator on 2016/6/2.
 */
public class QQlogin2 extends Activity {
    CheckBox cb;
    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qqlogin2);
        sp = getSharedPreferences("login", MODE_PRIVATE);
        editor = sp.edit();
        cb = (CheckBox) findViewById(R.id.clearuser);
    }

    public void logout(View view) {

        if (cb.isChecked()) {
            editor.putString("username", "000");
            editor.putString("userpw", "000");
            editor.commit();
        }
        Intent i = new Intent(this, QQlogin.class);
        startActivity(i);

    }
}
