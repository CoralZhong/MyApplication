package com.example.administrator.myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Administrator on 2016/6/12.
 */
public class UploadStuInfo extends BaseActivity {
    EditText sid;
    EditText sname;
    EditText sbirth;
    EditText imgname;
    Button chooseimg;
    Button upload;
    File file;
    Bitmap bmp;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.uploadstuinfo);
        sid = (EditText) findViewById(R.id.sid);
        sname = (EditText) findViewById(R.id.sname);
        sbirth = (EditText) findViewById(R.id.sbirth);
        chooseimg = (Button) findViewById(R.id.chooseimg);
        upload = (Button) findViewById(R.id.uploadinfobtn);
        imgname= (EditText) findViewById(R.id.imgname);

        chooseimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }

        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            System.out.println("requestCode" + requestCode);

            if (requestCode == 2) {
                Uri uri = data.getData();

                System.out.println(uri.getPath());
                imgname.setText(uri.getPath());
                file = new File(uri.getPath());

                ContentResolver cr = this.getContentResolver();

                try {
                    bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));


                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}



