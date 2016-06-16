package com.example.administrator.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/6/13.
 */
public class CompassActivity extends BaseActivity implements SensorEventListener {
    ImageView iv;
    float current = 0f;
    private SensorManager ss;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.compassactivity);
        iv= (ImageView) findViewById(R.id.compass);
        ss= (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ss.registerListener(this, ss.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        ss.unregisterListener(this);
        super.onStop();

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        float degree = event.values[0];

        int sensorType = event.sensor.getType();
        switch (sensorType) {
            case Sensor.TYPE_ORIENTATION:
                RotateAnimation ra = new RotateAnimation(current, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setDuration(200);
                iv.startAnimation(ra);
                current = -degree;
                break;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}