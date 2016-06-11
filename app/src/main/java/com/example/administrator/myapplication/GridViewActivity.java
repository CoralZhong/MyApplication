package com.example.administrator.myapplication;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/6.
 */
public class GridViewActivity extends BaseActivity {
    GridView gv;
    ImageView iv;
    int[] imgid={R.drawable.bom_f01,R.drawable.icon_37,R.drawable.icon_33,R.drawable.icon_28,R.drawable.icon_11,R.drawable.bom_f11};
    String[]goodsname={"商品1","商品2","商品3","商品4","商品5","商品6"};
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.gridview);
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<imgid.length;i++){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",imgid[i]);
            map.put("goodsname",goodsname[i]);
            list.add(map);
        }
        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.girdview2,new String[]{"image","goodsname"},new int[]{R.id.headerimg,R.id.goodsname1});
        gv= (GridView) findViewById(R.id.gridview1);
        gv.setAdapter(sa);
    }
}
