package com.example.fishgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView tank;
    ImageView fish;
    ImageView button;
    ImageView crack;
    ImageView table;
    Timer timer;
    TimerTask timerTask;
    TextView timerText;
    Double time = 0.0;
    final MediaPlayer mp = MediaPlayer.create(this, R.raw.break1);
    int count=0;
    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crack.setVisibility(View.INVISIBLE);
        tank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                    count++;
                } else {
                    //deprecated in API 26
                    v.vibrate(500);
                    count++;
                }
                if (count ==5 ){
                    crack.setVisibility(View.VISIBLE);
                    mp.start();
                }
            }
        });
        fish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                for (int i=0; i<5; i++){
                    fish.animate().x(50f).y(100f);
                }

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                setContentView(R.layout.outside);

            }
        });

    }
}
//setContentView(R.layout.activity_cast);