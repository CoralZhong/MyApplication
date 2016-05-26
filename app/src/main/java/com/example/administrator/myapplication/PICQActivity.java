package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 2016/4/7.
 */
public class PICQActivity extends Activity {
    EditText name;
    EditText password;
    CheckBox auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picq_layout);

        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        auto = (CheckBox) findViewById(R.id.auto);
    }

    public void loginPP (View v){
        if ("1728840871".equals(name.getText().toString())&&"1728840871".equals(password.getText().toString())){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
        }
    }
}
