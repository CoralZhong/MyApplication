package com.example.administrator.myapplication;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Bomb extends BaseActivity {
    ImageView iv;
    AnimationDrawable ad;
    MediaPlayer music;

    @Override
    void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.bomb);
        iv = (ImageView) findViewById(R.id.bomb);
        ad = (AnimationDrawable) iv.getBackground();
    }

    public void play(View view) {
        ad.start();
        if (music == null) {
            music = MediaPlayer.create(this, R.raw.bomb);
        }
        music.start();


    }

    public void stop(View view) {
        ad.stop();
    }
}
