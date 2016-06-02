package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Administrator on 16-5-17.
 */
public class RadioButton extends BaseActivity{


    @Override
    void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.radiobutton);
    }

    public void choose(View view){
        RadioGroup rb= (RadioGroup) findViewById(R.id.group);
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.radioButton){
                    Toast.makeText(RadioButton.this, "您选择了男", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.radioButton2){
                    Toast.makeText(RadioButton.this, "您选择了女", Toast.LENGTH_SHORT).show();
               }
// else if(checkedId==R.id.radioButton3){
//                    Toast.makeText(RadioButton.this, "您选择了三国演义", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        CheckBox cb1= (CheckBox) findViewById(R.id.cb1);
        CheckBox cb2= (CheckBox) findViewById(R.id.cb2);
        CheckBox cb3= (CheckBox) findViewById(R.id.cb3);
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(RadioButton.this, "您选择了专科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RadioButton.this, "您取消了专科", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(RadioButton.this, "您选择了本科", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RadioButton.this, "您取消了本科", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(RadioButton.this, "您选择了研究生", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RadioButton.this, "您取消了研究生", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

}
