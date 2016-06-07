package com.example.administrator.myapplication;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by Administrator on 2016/6/7.
 */
public class TabHostActivity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhostactivity);
        TabHost th=getTabHost();
        TabHost.TabSpec tab1 = th.newTabSpec("tab1").setIndicator("吃饭").setContent(R.id.tab1);
        th.addTab(tab1);

        TabHost.TabSpec tab2 = th.newTabSpec("tab2").setIndicator("睡觉").setContent(R.id.tab2);
        th.addTab(tab2);

        TabHost.TabSpec tab3 = th.newTabSpec("tab3").setIndicator("打豆豆").setContent(R.id.tab3);
        th.addTab(tab3);
    }
}
