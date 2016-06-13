package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/6/7.
 */
public class MenuActivity extends BaseActivity {
    final int FONT_10 = 0X111;
    final int FONT_12 = 0X112;
    final int FONT_14 = 0X113;
    final int FONT_16 = 0X114;

    final int PLAIN_ITEM = 0x11b;

    final int FONT_RED = 0X116;
    final int FONT_BLUE = 0X117;
    final int FONT_GREEN = 0X118;

    TextView tv;

    //上下文
    final int MENU1 = 0x111;
    final int MENU2 = 0X112;
    final int MENU3 = 0X113;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.menuactivity);
        tv = (TextView) findViewById(R.id.changeabletext);
        registerForContextMenu(tv);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu m1 = menu.addSubMenu("字体大小");
        m1.setHeaderTitle("选择字体大小");
        m1.add(0, FONT_10, 0, "10号字体");
        m1.add(0, FONT_12, 0, "12号字体");
        m1.add(0, FONT_14, 0, "14号字体");
        m1.add(0, FONT_16, 0, "16号字体");
        menu.add(0, PLAIN_ITEM, 0, "普通菜单项");
        SubMenu m2 = menu.addSubMenu("字体颜色");
        m2.setHeaderTitle("选择文字颜色");
        m2.add(0, FONT_RED, 0, "红色");
        m2.add(0, FONT_BLUE, 0, "蓝色");
        m2.add(0, FONT_GREEN, 0, "绿色");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case FONT_10:
                tv.setTextSize(10 * 2);
                break;
            case FONT_12:
                tv.setTextSize(12 * 2);
                break;
            case FONT_14:
                tv.setTextSize(14 * 2);
                break;
            case FONT_16:
                tv.setTextSize(16 * 2);
                break;
            case FONT_RED:
                tv.setTextColor(Color.RED);
                break;
            case FONT_BLUE:
                tv.setTextColor(Color.BLUE);
                break;
            case FONT_GREEN:
                tv.setTextColor(Color.GREEN);
                break;


        }
        return true;

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, MENU1, 0, "红色");
        menu.add(0, MENU2, 0, "绿色");
        menu.add(0, MENU3, 0, "蓝色");
        menu.setGroupCheckable(0, true, true);
        menu.setHeaderTitle("选择背景色");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU1:
                item.setChecked(true);
                tv.setBackgroundColor(Color.RED);
                break;
            case MENU2:
                item.setChecked(true);
                tv.setBackgroundColor(Color.GREEN);
                break;
            case MENU3:
                item.setChecked(true);
                tv.setBackgroundColor(Color.BLUE);
                break;
        }
        return true;
    }
}
