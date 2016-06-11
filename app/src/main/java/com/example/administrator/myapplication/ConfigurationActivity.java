package com.example.administrator.myapplication;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.GridLayout;

/**
 * Created by TOSHIBA on 2016/6/11.
 */
public class ConfigurationActivity extends BaseActivity {
    GridLayout gl;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
                         setContentView(R.layout.configurationactivity);
                         gl= (GridLayout) findViewById(R.id.gridlayout);


                         Configuration config = getResources().getConfiguration();
                         if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                                 gl.setColumnCount(3);
                                 gl.setRowCount(2);
                             }
                        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
                                 gl.setColumnCount(2);
                                 gl.setRowCount(3);
                             }
                     }


    }

