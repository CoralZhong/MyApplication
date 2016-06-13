package com.example.administrator.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.PhoneCity;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/5/31.
 */
public class PhoneCallAttribution extends BaseActivity {
    EditText et;
    TextView tv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.phonecallattribution);

    }

    Handler h=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String str = (String) b.get("str");
            tv= (TextView) findViewById(R.id.attribution);
            Gson gson = new Gson();
            PhoneCity pc = gson.fromJson(str,PhoneCity.class);
            if("success".equals(pc.getRetMsg()))
            {
                tv.setText(pc.getRetData().getProvince()+"省"+pc.getRetData().getCity()+"市"+pc.getRetData().getSupplier());
            }else {
                tv.setText("未查询到！");
        }
        }
    };
//    Button b= (Button) findViewById(R.id.searchbtn);

    public void search(View view){

        (new Thread(){
            @Override
            public void run() {
                et= (EditText) findViewById(R.id.phonenum);
                String httpUrl = "http://apis.baidu.com/apistore/mobilenumber/mobilenumber";
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?phone="+et.getText().toString();

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "562bafef6007883e2e8fffbbdfa9e6ac");
                    connection.connect();
                    InputStream is = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String strRead = null;
                    while ((strRead = reader.readLine()) != null) {
                        sbf.append(strRead);
                        sbf.append("\r\n");
                    }
                    reader.close();
                    result = sbf.toString();

                    Message m = new Message();
                    Bundle b = new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h.sendMessage(m);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
