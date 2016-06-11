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
    String[] name=new String[]{"1.Hello World","2.打开一张图片","3.获取手机信息","4.轮循换图","5.点击画心","6-1.电话号码布局","6-2.QQ登录布局","6-3.登录布局",
            "7.霓虹灯","8.梅花布局", "9.计算器布局","9-1.飞机拖动","10.连接电话本","11.单选多选按钮","12.短信验证",
            "12-1.弹球游戏","12-2.手机归属地查询","12-3.菜谱","13.QQ内部布局","13-1.下拉列表显示学历","13-2.自动播放广告",
            "14.每隔3秒显示不同的View","15&18.自动搜索","17.GridView显示两列商品","19.选择日期","20.选项卡TabHost","22.MENU","23.弹出对话框",
            "vedioview视频播放",
            "录音","23-3.国际化","24.点击按钮打电话发短信","24-1.点击按钮获取联系人信息","25.选择省份城市","26.横竖屏切换","27.下载并显示进度条",
            "30-1.双缓冲技术画心",
            "30-2.画板","30-3.爆炸逐帧动画","31.自动登录","32-1.文件浏览器","33.左右划改变图片大小","34.左右划换页","35.自定义手势","36.百度语音"};

    Class[] clazz = {HelloWorld.class,APicture.class,GetResolution.class,ChangePicture.class,showheart.class,TelLayout.class,QQLoginLayout.class,LoginLayout.class,
            ChangeColorActivity.class,RelativeLayout.class,CalculatorLayout.class,CalculatorLayout.class,LinktoTelNum.class,RadioButton.class,Message60seconds.class,
            BALLSHOW.class,PhoneCallAttribution.class,CookBook.class,QQInnerLayout.class,EducationalLevel_spinner.class,Advertisement.class,
            Switch3seconds.class,Dictionary.class, GridViewActivity.class,DateChooser.class,TabHostActivity.class,MenuActivity.class,DialogActivity.class,
            VideoViewActivity.class,
            MediaRecorderActivity.class,InternationalHello.class,SendMsgPhoneCall.class,GetLinkMan.class,ProvinceCity.class,Download.class,
            showheart.class,
            Board.class,Bomb.class,QQlogin.class,FileBrowser.class,PicBigSmall.class,ChangePicLR.class,GestureActivity.class,Speaker.class};
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


        ListView lv= (ListView) findViewById(R.id.hlist);
        ArrayAdapter aad=new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,name);
        lv.setAdapter(aad);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(main.this,clazz[position]);
                    startActivity(i);
                }
            });
        }



//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            Intent intent;
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch(position){
//                    case 0:intent=new Intent(main.this,HelloWorld.class);startActivity(intent);break;
//                    case 1:intent=new Intent(main.this,APicture.class);startActivity(intent);break;
//                    case 2:intent=new Intent(main.this,GetResolution.class);startActivity(intent);break;
//                    case 3:intent=new Intent(main.this,ChangePicture.class);startActivity(intent);break;
//                    case 4:intent=new Intent(main.this,showheart.class);startActivity(intent);break;
//                    case 5:intent=new Intent(main.this,TelLayout.class);startActivity(intent);break;
//                    case 6:intent=new Intent(main.this,QQLoginLayout.class);startActivity(intent);break;
//                    case 7:intent=new Intent(main.this,LoginLayout.class);startActivity(intent);break;
//                    case 8:intent=new Intent(main.this,ChangeColorActivity.class);startActivity(intent);break;
//                    case 9:intent=new Intent(main.this,RelativeLayout.class);startActivity(intent);break;
//                    case 10:intent=new Intent(main.this,CalculatorLayout.class);startActivity(intent);break;
//                    case 11:intent=new Intent(main.this,CalculatorLayout.class);startActivity(intent);break;
//                    case 12:intent=new Intent(main.this,LinktoTelNum.class);startActivity(intent);break;
//                }
//            }
//        });


    }

