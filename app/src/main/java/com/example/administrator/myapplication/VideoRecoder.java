package com.example.administrator.myapplication;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Administrator on 2016/6/15.
 */
public class VideoRecoder extends BaseActivity implements View.OnClickListener {
    Button record, stop;

    File videoFile;
    MediaRecorder mRecorder;

    SurfaceView sView;
    private boolean isRecording = false;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.videorecorder);

        record = (Button) findViewById(R.id.record);
        stop = (Button) findViewById(R.id.stop);

        stop.setEnabled(false);

        record.setOnClickListener(this);
        stop.setOnClickListener(this);

        sView = (SurfaceView) this.findViewById(R.id.sView);
        sView.getHolder().setFixedSize(320, 280);
        sView.getHolder().setKeepScreenOn(true);

    }

    @Override
    public void onClick(View source) {
        switch (source.getId()) {
            case R.id.record:
                if (!Environment.getExternalStorageState().equals(
                        android.os.Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(VideoRecoder.this
                            , "SD卡不存在，请插入SD卡！"
                            , Toast.LENGTH_SHORT).show();
                    return;
                }
                try {

                    videoFile = new File(Environment
                            .getExternalStorageDirectory()
                            .getCanonicalFile() + "/myvideo.mp4");

                    mRecorder = new MediaRecorder();
                    mRecorder.reset();

                    mRecorder.setAudioSource(MediaRecorder
                            .AudioSource.MIC);

                    mRecorder.setVideoSource(MediaRecorder
                            .VideoSource.CAMERA);

                    mRecorder.setOutputFormat(MediaRecorder
                            .OutputFormat.MPEG_4);

                    mRecorder.setAudioEncoder(MediaRecorder
                            .AudioEncoder.DEFAULT);

                    mRecorder.setVideoEncoder(MediaRecorder
                            .VideoEncoder.MPEG_4_SP);
                    mRecorder.setVideoSize(320, 280);

                    mRecorder.setVideoFrameRate(4);
                    mRecorder.setOutputFile(videoFile.getAbsolutePath());

                    mRecorder.setPreviewDisplay(sView
                            .getHolder().getSurface());  // ①
                    mRecorder.prepare();

                    mRecorder.start();
                    System.out.println("---recording---");
                    record.setEnabled(false);

                    stop.setEnabled(true);
                    isRecording = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case R.id.stop:

                if (isRecording) {
                    mRecorder.stop();
                    mRecorder.release();
                    mRecorder = null;
                    record.setEnabled(true);
                    stop.setEnabled(false);
                }
                break;
        }
    }


}
