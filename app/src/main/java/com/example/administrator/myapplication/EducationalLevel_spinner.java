package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Administrator on 2016/6/2.
 */
public class EducationalLevel_spinner extends BaseActivity {
    Spinner sp;
    @Override
    void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.educationallevel);
        sp= (Spinner) findViewById(R.id.spinner);
        String[] edu={"小学","初中","高中","专科","本科","研究生"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,edu);
        sp.setAdapter(adapter);
            }
}
