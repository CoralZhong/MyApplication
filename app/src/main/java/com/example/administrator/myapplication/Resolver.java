package com.example.administrator.myapplication;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Administrator on 2016/6/6.
 */
public class Resolver extends BaseActivity {
    ListView lv;
    ContentResolver contentResolver;
    Uri uri=Uri.parse("content://com.ralph.second/students");
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.resolver);
        contentResolver=getContentResolver();
        lv= (ListView) findViewById(R.id.resolverlist);
        Cursor c=contentResolver.query(uri,null,null,null,null);
        SimpleCursorAdapter sca=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,c,new String[]{"name","age"},new int[]{});
    }
}
