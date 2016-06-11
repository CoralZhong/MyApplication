package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by TOSHIBA on 2016/6/11.
 */
public class SendMsgPhoneCall extends BaseActivity {
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.sendmsgphonecall);
    }

    public void call(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:1599851665"));
        startActivity(i);
    }

    public void sendmess(View view) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("smsto:15998851665"));
        startActivity(i);
    }
}
