package com.example.thomaskirouac_antoinedumasfortin_daveloignon.projetandroid;

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



public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;

    TextView tvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_view_image);
        initListener();
    }

    private void initListener() {
        /*ImageView imgFavorite = (ImageView) findViewById(R.id.imageView_futurama);
        imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOnMap();
            }
        });*/

        Button btnScrollUp = (Button) findViewById(R.id.btn_scrollUp);
        btnScrollUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollUp();
            }
        });
    }

    private void scrollUp() {
        ScrollView scrollView = (ScrollView)  findViewById(R.id.scrollView);
        LinearLayout linearLayout = (LinearLayout)  findViewById(R.id.linearLayout);

        linearLayout.animate().translationY(linearLayout.getHeight());
    }

    private void showOnMap() {

        ImageView imgFavorite = (ImageView) findViewById(R.id.imageView_futurama);
        imgFavorite.animate().rotation(imgFavorite.getRotation() + 360);
        Toast.makeText(MainActivity.this,
                "The favorite list would appear on clicking this icon",
                Toast.LENGTH_LONG).show();
    }




}
