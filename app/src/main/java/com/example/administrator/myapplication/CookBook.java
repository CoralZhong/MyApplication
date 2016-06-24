package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.cook;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    EditText et;
    Button btn;
    TextView tt;
    ListView lv;
    List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    Bitmap bm;

    Handler h2=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle b=msg.getData();
            String str= (String) b.get("str");
            Gson g=new Gson();
            cook cp=g.fromJson(str,cook.class);
            List<cook.TngouBean> l=cp.getTngou();

            int i=0;
            for(cook.TngouBean ct:l){
                Map<String,String> map=new HashMap<String,String>();
                map.put("img","http://tnfs.tngou.net/image"+ct.getImg());
                String food= Html.fromHtml(ct.getFood()).toString();
                map.put("food",food);
                String message=Html.fromHtml(ct.getMessage()).toString();
                map.put("message",message);
                list.add(map);
                i++;
                if(i>20){
                    break;
                }
            }
//            SimpleAdapter sa = new SimpleAdapter(homework_api_caipu_activity.this,list,R.layout.homework_api_caipu_bean,
//                    new String[]{"img","food","message"},new int[]{R.id.img,R.id.food,R.id.message});
//            lv.setAdapter(sa);
            MyAdpater ad = new MyAdpater();
            lv.setAdapter(ad);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Map<String,String> map=list.get(position);
                    Intent i=new Intent(CookBook.this,CookDetails.class);
                    Bundle b=new Bundle();
                    b.putSerializable("info", (Serializable) map);
                    i.putExtra("a",b);
                    startActivity(i);
                }

            });

        }
    };


    class MyAdpater extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = LayoutInflater.from(CookBook.this);
            View view = li.inflate(R.layout.cookbooklayout,null);

            ImageView iv= (ImageView) view.findViewById(R.id.img);
            TextView foodtv= (TextView) view.findViewById(R.id.food);
            TextView message= (TextView) view.findViewById(R.id.message);

            Map<String,String> map = list.get(position);
            try {
                final URL url = new URL(map.get("img"));

                (new Thread(){
                    @Override
                    public void run() {
                        try {
                            bm= BitmapFactory.decodeStream(url.openStream());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                iv.setImageBitmap(bm);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            foodtv.setText(map.get("food"));
            //message.setText(map.get("message"));

            return view;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.cookbook);
        et= (EditText) findViewById(R.id.input);
        btn= (Button) findViewById(R.id.btn);
        tt= (TextView) findViewById(R.id.test);
        lv= (ListView) findViewById(R.id.cooklist);

    }

    public void findcook(View view){
        String name=et.getText().toString();
        final String s="name="+name;


        (new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    String httpUrl = "http://apis.baidu.com/tngou/cook/name";
                    BufferedReader reader = null;
                    String result = null;
                    StringBuffer sbf = new StringBuffer();
                    httpUrl = httpUrl + "?" + s;
                    URL url = new URL(httpUrl);
                    HttpURLConnection connection = (HttpURLConnection) url
                            .openConnection();
                    connection.setRequestMethod("GET");
                    // 填入apikey到HTTP header
                    connection.setRequestProperty("apikey",  "2971243f61b450c3d5e00fda852939b1");
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
                    Message m=new Message();
                    Bundle b=new Bundle();
                    b.putSerializable("str",result);
                    m.setData(b);
                    h2.sendMessage(m);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
