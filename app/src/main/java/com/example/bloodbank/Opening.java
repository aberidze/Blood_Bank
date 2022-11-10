package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Opening extends AppCompatActivity {
    LottieAnimationView lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        lt = findViewById(R.id.animationView);
        lt.animate().setDuration(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent beginning = new Intent(Opening.this, StartPage.class);
                startActivity(beginning);
            }
        }, 2500);
    }
}