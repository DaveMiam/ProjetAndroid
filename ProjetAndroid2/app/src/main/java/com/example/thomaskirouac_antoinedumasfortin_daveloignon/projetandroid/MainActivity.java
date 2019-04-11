package com.example.thomaskirouac_antoinedumasfortin_daveloignon.projetandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    private float currentDegree = 0f;
    private static SensorManager mySensorManager;
    TextView orrientationZ;
    private boolean sersorrunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "fafalalala", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        orrientationZ = (TextView)findViewById(R.id.txt_orrientation);
        Toast.makeText(this, "fafalalala", Toast.LENGTH_SHORT).show();
        mySensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mySensors = mySensorManager.getSensorList(Sensor.TYPE_ORIENTATION);

        if(mySensors.size() > 0){
            mySensorManager.registerListener(mySensorEventListener, mySensors.get(0), SensorManager.SENSOR_DELAY_NORMAL);
            sersorrunning = true;
            Toast.makeText(this, "Start ORIENTATION Sensor", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "No ORIENTATION Sensor", Toast.LENGTH_LONG).show();
            sersorrunning = false;
            finish();
        }
    }

    private SensorEventListener mySensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent event) {


            orrientationZ.setText("Azimuth: " + String.valueOf(event.values[0]));
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {


        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(sersorrunning){
            mySensorManager.unregisterListener(mySensorEventListener);
            Toast.makeText(this, "unregisterListener", Toast.LENGTH_SHORT).show();
        }
    }

}
