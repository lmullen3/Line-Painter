package com.example.lawrencemullen.dotpainter2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class activity1 extends AppCompatActivity implements SensorEventListener{

    private SensorManager sensorManager;
    private Sensor mAccel;

    private TextView xTextView,yTextView,zTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccel=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        xTextView = (TextView) findViewById(R.id.xInput);
        yTextView = (TextView) findViewById(R.id.yInput);
        zTextView = (TextView) findViewById(R.id.zInput);

    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this, mAccel,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
    sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        xTextView.setText(event.values[0] + "");
        yTextView.setText(event.values[1] + "");
        zTextView.setText(event.values[2] + "");

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

}

