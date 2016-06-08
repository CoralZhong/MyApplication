package com.example.administrator.myapplication;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/6/8.
 */
public class MediaRecorderActivity extends BaseActivity {
    MediaRecorder recorder;
    MediaPlayer mp;

    File file;
    @Override
    void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.mediarecorderactivity);
    }

    public void record(View view)
    {
        file = new File("/mnt/sdcard/sound3.amr");
        try{
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(file.getAbsolutePath());

            recorder.prepare();
            recorder.start();
        }catch(Exception e){
        }
    }

    public void stoprecord(View view)
    {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
    }
    public void playrecord(View view){

        try {
            mp=MediaPlayer.create(this, Uri.parse("/mnt/sdcard/sound3.amr"));
            //mp.setDataSource("/mnt/sdcard/sound1.amr");
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    protected void onDestroy() {
        if(file != null && file.exists())
        {
            recorder.stop();
            recorder.release();
            recorder = null;
            file = null;
        }
        super.onDestroy();
    }
}
