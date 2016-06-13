package com.example.administrator.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.ImageView;

import java.security.KeyStore;

/**
 * Created by Administrator on 2016/6/13.
 */
public class ShakeShake extends BaseActivity implements SensorEventListener{
    private SensorManager ss;
    ImageView iv;
    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.shake);
        iv= (ImageView) findViewById(R.id.shakegif);
        ss= (SensorManager) getSystemService(SENSOR_SERVICE);
        iv.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ss.registerListener(this,ss.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION),SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        ss.unregisterListener(this);
        super.onStop();

    }

    @Override
    protected void onPause() {
        ss.unregisterListener(this);
        super.onPause();
    }
    int abc=0;

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[]values=event.values;
        int sensorType=event.sensor.getType();
       switch (sensorType){
           case Sensor.TYPE_LINEAR_ACCELERATION:
               abc++;
               if(abc>40) {
                   iv.setVisibility(View.VISIBLE);
                   abc=0;
               }
       }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
