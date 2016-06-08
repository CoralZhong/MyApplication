package com.example.administrator.myapplication;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

/**
 * Created by Administrator on 2016/6/8.
 */
public class VideoViewActivity extends BaseActivity {
    VideoView vv;
    MediaController mc;
    @Override
    void initContentView(Bundle savedInstanceState) {
     setContentView(R.layout.videoviewactivity);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        vv= (VideoView) findViewById(R.id.video);
        mc=new MediaController(this);
        File video=new File("mnt/shared/Other/song.mp4");
        if(video.exists()){
            vv.setVideoPath(video.getAbsolutePath());
            vv.setMediaController(mc);
            mc.setMediaPlayer(vv);
            vv.requestFocus();
        }


    }
}
