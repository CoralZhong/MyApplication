package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/3.
 */
public class FileBrowser extends Activity {
    ListView lv;
    TextView tv;
    File currentParent;
    File[] currentFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filebrowser);
        lv= (ListView) findViewById(R.id.list);
        tv= (TextView) findViewById(R.id.path);
        File root=new File("/mnt/sdcard/");
        if(root.exists()){
            currentParent=root;
            currentFiles=root.listFiles();
            inflatelistView(currentFiles);
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentFiles[position].isFile()) {return;}
                File[]tmp=currentFiles[position].listFiles();
                if(tmp==null||tmp.length==0){
                    Toast.makeText(FileBrowser.this, "无文件！", Toast.LENGTH_SHORT).show();
                    }else{
                    currentParent=currentFiles[position];
                    currentFiles=tmp;
                    inflatelistView(currentFiles);
                }
            }
        });
        Button parent= (Button) findViewById(R.id.parent);
        parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!currentParent.getCanonicalPath().equals("/mnt/sdcard/")){
                        currentParent=currentParent.getParentFile();
                        currentFiles=currentParent.listFiles();
                        inflatelistView(currentFiles);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void inflatelistView(File[]files){
        List<Map<String,Object>>listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<files.length;i++){
            Map<String,Object>listitem=new HashMap<String,Object>();
            if(files[i].isDirectory()){
                listitem.put("icon",R.drawable.folder1);
            }else{
                listitem.put("icon",R.drawable.file1);
            }
            listitem.put("fileName",files[i].getName());
            listItems.add(listitem);
        }
        SimpleAdapter sa=new SimpleAdapter(this,listItems,R.layout.filebrowserline,new String[]{"icon","fileName"},new int[]{R.id.imgfolder,R.id.foldname});
        lv.setAdapter(sa);
        try {
            tv.setText("当前路径为："+currentParent.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
