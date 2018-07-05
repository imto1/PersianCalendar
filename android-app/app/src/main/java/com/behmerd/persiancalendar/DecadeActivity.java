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

        final GridView gvmc = (GridView) findViewById(R.id.gvYC);
        final TextView tvnow = (TextView) findViewById(R.id.tvYear);
        ImageView ivup = (ImageView) findViewById(R.id.ivUY);
        ImageView ivduown = (ImageView) findViewById(R.id.ivDY);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
        tvnow.setTypeface(tf);

        PersianCalendar calendar = new PersianCalendar();
        if(getIntent().getExtras() != null)
            year = getIntent().getExtras().getInt("year");
        else
            year = calendar.Now.Year();

        decade = year % 10;
        decade = year - decade;
        tvnow.setText(String.valueOf(decade + 9) + " - " + String.valueOf(decade));

        gvmc.setAdapter(new DecadeView(getApplicationContext(), year));

        ivup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year -= 10;
                gvmc.setAdapter(new DecadeView(getApplicationContext(), year));
                decade = year % 10;
                decade = year - decade;
                tvnow.setText(String.valueOf(decade + 9) + " - " + String.valueOf(decade));
            }
        });

        ivduown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year += 10;
                gvmc.setAdapter(new DecadeView(getApplicationContext(), year));
                decade = year % 10;
                decade = year - decade;
                tvnow.setText(String.valueOf(decade+9) + " - " + String.valueOf(decade));
            }
        });
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
