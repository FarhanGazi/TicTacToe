package com.example.farhan.pushsum.activity;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.farhan.pushsum.R;
import com.example.farhan.pushsum.adapter.SliderAdapter;

public class TutorialActivity extends AppCompatActivity {

    private ViewPager nSlideViewPager;
    private LinearLayout nDotLayout;

    private SliderAdapter sliderAdapter;

    private TextView[] nDots;

    private AppCompatButton next;
    private AppCompatButton prec;
    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        nSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        nDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        next = findViewById(R.id.next);
        prec = findViewById(R.id.prec);

        sliderAdapter = new SliderAdapter(this);
        nSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        nSlideViewPager.addOnPageChangeListener(viewListener);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage == 2) finish();
                nSlideViewPager.setCurrentItem(currentPage + 1);
            }
        });

        prec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nSlideViewPager.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position) {
        nDots = new TextView[3];
        nDotLayout.removeAllViews();
        for (int i = 0; i < nDots.length; i++) {
            nDots[i] = new TextView(this);
            nDots[i].setText(Html.fromHtml("&#8226;"));
            nDots[i].setTextSize(35);
            nDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            nDotLayout.addView(nDots[i]);

        }

        if (nDots.length > 0) {
            nDots[position].setTextColor(getResources().getColor(R.color.colorPosition));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            currentPage = position;

            if (position == 0) {
                next.setEnabled(true);
                prec.setEnabled(false);
                prec.setVisibility(View.INVISIBLE);

                next.setText("Next");
                prec.setText("");
            } else if (position == nDots.length - 1) {
                next.setEnabled(true);
                prec.setEnabled(true);
                prec.setVisibility(View.VISIBLE);

                next.setText("Finish");
                prec.setText("Back");
            } else {
                next.setEnabled(true);
                prec.setEnabled(true);
                prec.setVisibility(View.VISIBLE);

                next.setText("Next");
                prec.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
