package com.example.administrator.myapplication;

import com.example.administrator.myapplication.bean.Stock;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface StockInterface  {
    @GET("/apistore/stockservice/hkstock")
    Call<Stock>getStockInfo(@Header("apikey") String apikey, @Query("stockid") String stockid,@Query("list") String list );

}
