package com.example.administrator.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/14.
 */
public class BroadcastReceiverTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //拿到我们注册的广播类型
        String action = intent.getAction();
        Log.d("TAG",action);
        //TODO 处理自己逻辑...
    }
}