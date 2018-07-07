package com.behmerd.persiancalendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.behmerd.persiancalendar.common.PersianCalendar;
import com.behmerd.persiancalendar.views.YearView;


public class YearActivity extends Activity {

    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        final GridView gvContentPlace = (GridView) findViewById(R.id.yearGVContentPlace);
        final TextView tvNow = (TextView) findViewById(R.id.yearTVMonth);
        ImageView ivUp = (ImageView) findViewById(R.id.yearIVUp);
        ImageView ivDown = (ImageView) findViewById(R.id.yearIVDown);
        final String[] month = getResources().getStringArray(R.array.monthList);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
        tvNow.setTypeface(typeface);

        PersianCalendar calendar = new PersianCalendar();
        if(getIntent().getExtras() != null)
            year = getIntent().getExtras().getInt("year");
        else
            year = calendar.Now.Year();

        tvNow.setText(String.valueOf(year));

        gvContentPlace.setAdapter(new YearView(getApplicationContext(), year, month));

        ivUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year--;
                gvContentPlace.setAdapter(new YearView(getApplicationContext(), year, month));
                tvNow.setText(String.valueOf(year));
            }
        });

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year++;
                gvContentPlace.setAdapter(new YearView(getApplicationContext(), year, month));
                tvNow.setText(String.valueOf(year));
            }
        });

        tvNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(YearActivity.this,DecadeActivity.class);
                intent.putExtra("year",year);
                startActivity(intent);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}