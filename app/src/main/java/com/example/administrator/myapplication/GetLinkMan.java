package com.example.administrator.myapplication;

import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by TOSHIBA on 2016/6/10.
 */
public class GetLinkMan extends BaseActivity {
    final int PICK_CONTACT=0;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
     setContentView(R.layout.getlinkman);
        Button b= (Button) findViewById(R.id.showbtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_GET_CONTENT);
                i.setType("vnd.android.cursor.item/phone");
                startActivityForResult(i,PICK_CONTACT);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case PICK_CONTACT:if(resultCode== Activity.RESULT_OK){
                Uri contactData=data.getData();
                CursorLoader cursorLoader=new CursorLoader(this,contactData,null,null,null,null);
                Cursor cursor=cursorLoader.loadInBackground();
                if(cursor.moveToFirst()){
                    String contactID=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    String phoneaNumber="此联系人暂未输入电话号码";
                    Cursor phones=getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+"="+contactID,null,null);
                    if(phones.moveToFirst())
                    {
                        phoneaNumber=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    }
                    phones.close();
                    EditText show= (EditText) findViewById(R.id.showlinkman);
                    show.setText(name);
                    EditText phone= (EditText) findViewById(R.id.showphonenumber);
                    phone.setText(phoneaNumber);
                }
                cursor.close();
            }
                break;

        }
    }
}
