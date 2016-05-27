package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/25.
 */
public class main extends BaseActivity{
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.main);
//        TextView tv2= (TextView) findViewById(R.id.h2);
//        tv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2=new Intent(main.this,APicture.class);
//                startActivity(intent2);
//            }
//        });
        String[] name=new String[]{"1.Hello World","2.打开一张图片","3.获取手机信息","4.轮循换图","5.点击画心","6-1.电话号码布局","6-2.QQ登录布局","6-3.登录布局","7.霓虹灯","8.梅花布局",
                "9.计算器布局","10.飞机拖动","11.连接电话本"};
        ListView lv= (ListView) findViewById(R.id.hlist);
        ArrayAdapter aad=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,name);
        lv.setAdapter(aad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent;
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:intent=new Intent(main.this,HelloWorld.class);startActivity(intent);break;
                    case 1:intent=new Intent(main.this,APicture.class);startActivity(intent);break;
                    case 2:intent=new Intent(main.this,GetResolution.class);startActivity(intent);break;
                    case 3:intent=new Intent(main.this,ChangePicture.class);startActivity(intent);break;
                    case 4:intent=new Intent(main.this,showheart.class);startActivity(intent);break;
                    case 5:intent=new Intent(main.this,TelLayout.class);startActivity(intent);break;
                    case 6:intent=new Intent(main.this,QQLoginLayout.class);startActivity(intent);break;
                    case 7:intent=new Intent(main.this,LoginLayout.class);startActivity(intent);break;
                    case 8:intent=new Intent(main.this,ChangeColorActivity.class);startActivity(intent);break;
                    case 9:intent=new Intent(main.this,RelativeLayout.class);startActivity(intent);break;
                    case 10:intent=new Intent(main.this,CalculatorLayout.class);startActivity(intent);break;
                    case 11:intent=new Intent(main.this,CalculatorLayout.class);startActivity(intent);break;
                    case 12:intent=new Intent(main.this,LinktoTelNum.class);startActivity(intent);break;
                }
            }
        });


    }
}
