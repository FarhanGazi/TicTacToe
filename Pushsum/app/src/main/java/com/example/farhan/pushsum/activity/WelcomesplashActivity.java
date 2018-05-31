package com.example.farhan.pushsum.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.farhan.pushsum.R;

public class WelcomesplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    TextView mainTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomesplash);

        mainTitle = (TextView) findViewById(R.id.mainTitle);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
        mainTitle.setTypeface(typeface);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomesplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
