package com.behmerd.persiancalendar;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.behmerd.persiancalendar.common.PersianCalendar;
import com.behmerd.persiancalendar.views.DecadeView;


public class DecadeActivity extends Activity {

    private int year, decade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decade);

        final GridView gvContentPlace = (GridView) findViewById(R.id.yearGVContentPlace);
        final TextView tvNow = (TextView) findViewById(R.id.decadeTVYear);
        ImageView ivUp = (ImageView) findViewById(R.id.decadeIVUp);
        ImageView ivDown = (ImageView) findViewById(R.id.decadeIVDown);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
        tvNow.setTypeface(typeface);

        PersianCalendar calendar = new PersianCalendar();
        if(getIntent().getExtras() != null)
            year = getIntent().getExtras().getInt("year");
        else
            year = calendar.Now.Year();

        decade = year % 10;
        decade = year - decade;
        tvNow.setText(String.valueOf(decade + 9) + " - " + String.valueOf(decade));

        gvContentPlace.setAdapter(new DecadeView(getApplicationContext(), year));

        ivUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year -= 10;
                gvContentPlace.setAdapter(new DecadeView(getApplicationContext(), year));
                decade = year % 10;
                decade = year - decade;
                tvNow.setText(String.valueOf(decade + 9) + " - " + String.valueOf(decade));
            }
        });

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year += 10;
                gvContentPlace.setAdapter(new DecadeView(getApplicationContext(), year));
                decade = year % 10;
                decade = year - decade;
                tvNow.setText(String.valueOf(decade + 9) + " - " + String.valueOf(decade));
            }
        });
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
