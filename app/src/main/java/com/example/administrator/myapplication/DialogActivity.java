package com.example.administrator.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/6/8.
 */
public class DialogActivity extends BaseActivity {

        Button btn;
            @Override
            protected void initContentView(Bundle savedInstanceState) {
                     setContentView(R.layout.dialogactivity);
                     btn = (Button) findViewById(R.id.button36);
                 }
             public void tanchu(View view){
                    AlertDialog b = new AlertDialog.Builder(this)
                             .setTitle("对话框")
                             .setIcon(R.drawable.icon_11)
                             .setMessage("弹出对话框")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener()
                                     {
                                     @Override
                                     public void onClick(DialogInterface dialog, int which)
                                     {
                                             Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                                         }
                                })
                             .setNegativeButton("取消", new DialogInterface.OnClickListener()
                                    {
                                    @Override
                                     public void onClick(DialogInterface dialog, int which)
                                     {
                                             Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                                     }
                                })
                             .create();
                     b.show();
                }


    }

