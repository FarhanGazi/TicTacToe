package com.example.farhan.pushsum.activity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.farhan.pushsum.R;

public class HomeActivity extends AppCompatActivity {

    ImageView image_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        image_info = (ImageView) findViewById(R.id.image_info);
        image_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TutorialActivity.class);
                startActivity(intent);
            }
        });
    }
}
