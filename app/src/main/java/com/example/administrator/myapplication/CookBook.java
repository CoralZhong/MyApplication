package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.cook;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 16-5-18.
 */
public class CookBook extends Activity {
    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String s = (String) b.get("str");
            Gson gson=new Gson();
            cook c=gson.fromJson(s,cook.class);
            String hh=c.getTngou().size()+"";
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            for (cook.TngouBean t:c.getTngou()){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("pic",t.getImg());
                map.put("cookname",t.getName());
                map.put("message",t.getMessage());
                list.add(map);
            }

            ListView view = (ListView) findViewById(R.id.cooklist);
            SimpleAdapter sa = new SimpleAdapter(CookBook.this,list,R.layout.cookbook_row,new String[]{"pic","cookname","message"},new int[]{R.id.pic,R.id.cookname,R.id.cookdiscribe});
             view.setAdapter(sa);

            result.setText(hh);


        }
    };

    TextView result;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookbook);
        result = (TextView) findViewById(R.id.test);
        name= (EditText) findViewById(R.id.input);

    }

    public void findcook(View view) {
        (new Thread() {
            @Override
            public void run() {
                String httpUrl = "http://apis.baidu.com/tngou/cook/name";
                String httpArg = "name=%E5%AE%AB%E4%BF%9D%E9%B8%A1%E4%B8%81";
                BufferedReader reader = null;
                String result = null;
                StringBuffer sbf = new StringBuffer();
                httpUrl = httpUrl + "?name=" + name.getText().toString();

                try {
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey", "2971243f61b450c3d5e00fda852939b1");
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
                    b.putSerializable("str", result);
                    m.setData(b);
                    h.sendMessage(m);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();

    }
}
