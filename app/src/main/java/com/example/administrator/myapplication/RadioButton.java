package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 16-5-17.
 */
public class RadioButton extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton);
    }

    public void choose(View view){
        RadioGroup rb= (RadioGroup) findViewById(R.id.group);
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton){
                    Toast.makeText(RadioButton.this, "您选择了西游记", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.radioButton2){
                    Toast.makeText(RadioButton.this, "您选择了红楼梦", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.radioButton3){
                    Toast.makeText(RadioButton.this, "您选择了三国演义", Toast.LENGTH_SHORT).show();
                }
            }
        });






    }

}
