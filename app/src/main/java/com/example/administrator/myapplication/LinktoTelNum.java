package com.example.administrator.myapplication;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.QuickContactBadge;

/**
 * Created by Administrator on 2016/5/27.
 */
public class LinktoTelNum extends BaseActivity {

    @Override
    protected void
    initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.linktotelnum);
        QuickContactBadge qcb= (QuickContactBadge) findViewById(R.id.quickcontactbadge);
        qcb.assignContactFromPhone("15998851665",false);
    }
}
