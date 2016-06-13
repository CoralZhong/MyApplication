package com.example.administrator.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.Stock;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/12.
 */
public class StockActivity extends BaseActivity {

    EditText stockcode;
    Button b;
    TextView tv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.stockactivity);
        stockcode= (EditText) findViewById(R.id.stockid);
        b= (Button) findViewById(R.id.serachstock);
        tv= (TextView) findViewById(R.id.showstock);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder().baseUrl("http://apis.baidu.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                StockInterface stockInterface=retrofit.create(StockInterface.class);
                Call<Stock> call = stockInterface.getStockInfo("2971243f61b450c3d5e00fda852939b1",stockcode.getText().toString(),"0");
                  call.enqueue(new Callback<Stock>() {
                      @Override
                      public void onResponse(Call<Stock> call, Response<Stock> response) {
                          Stock s=response.body();
                          tv.setText("股票名称:"+s.getRetData().getStockinfo().getName()+"\n"+
                                  "股票代码:"+s.getRetData().getStockinfo().getCode()+"\n"+
                                  "日期:"+s.getRetData().getStockinfo().getDate()+"\n"+
                                  "开盘价:"+s.getRetData().getStockinfo().getOpenningPrice()+"\n"+
                                  "昨日收盘价:"+s.getRetData().getStockinfo().getClosingPrice()+"\n"+
                                  "今日最高价:"+s.getRetData().getStockinfo().getHPrice()+"\n"+
                                  "今日最低价:"+s.getRetData().getStockinfo().getLPrice()+"\n"+
                                  "当前价:"+s.getRetData().getStockinfo().getCurrentPrice()+"\n"+
                                  "价格涨幅:"+s.getRetData().getStockinfo().getGrowth()+"\n"+
                                  "价格涨幅比例，单位%:"+s.getRetData().getStockinfo().getGrowthPercent()+"\n"+
                                  "成交量股:"+s.getRetData().getStockinfo().getDealnumber()+"\n"+
                                  "成交金额，单位港币:"+s.getRetData().getStockinfo().getTurnover()+"\n"+
                                  "52周最高价:"+s.getRetData().getStockinfo().getValue52hPrice()+"\n"+
                                  "52周最低价:"+s.getRetData().getStockinfo().getValue52lPrice());
                      }


                      @Override
                      public void onFailure(Call<Stock> call, Throwable t) {
                          tv.setText("暂无该股票信息！");

                      }
                  });
            }
        });
    }
}
