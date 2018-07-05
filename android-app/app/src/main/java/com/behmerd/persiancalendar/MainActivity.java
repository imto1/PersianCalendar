package com.behmerd.persiancalendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.behmerd.persiancalendar.common.PersianCalendar;
import com.behmerd.persiancalendar.views.MonthView;
import com.behmerd.persiancalendar.views.WeekDays;

public class MainActivity extends Activity {

    int year, month, day;
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersianCalendar calendar = new PersianCalendar();
        final GridView gvcal=(GridView) findViewById(R.id.gvCalendar);
        GridView gvwd=(GridView) findViewById(R.id.gvWD);
        final TextView tvnow = (TextView) findViewById(R.id.tvNow);
        ImageView ivup = (ImageView) findViewById(R.id.ivU);
        ImageView ivduown = (ImageView) findViewById(R.id.ivDY);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");
        tvnow.setTypeface(typeface);


        if(getIntent().getExtras() != null){
            year = getIntent().getExtras().getInt("year");
            month = getIntent().getExtras().getInt("month");
        }
        else {
            month = calendar.Now.Month();
            year = calendar.Now.Year();
        }
        day = calendar.Now.Day();

        months=getResources().getStringArray(R.array.monthList);

        tvnow.setText(String.valueOf(months[month - 1] + " " + year));

        gvwd.setAdapter(new WeekDays(this, getResources().getString(R.string.wds).split("~")));
        gvcal.setAdapter(new MonthView(getApplicationContext(), year, month, day));

        ivup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month > 1)
                    month--;
                else {
                    year--;
                    month = 12;
                }
                gvcal.setAdapter(new MonthView(getApplicationContext(), year, month, day));
                tvnow.setText(String.valueOf(months[month - 1] + " " + year));
            }
        });

        ivduown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month < 12)
                    month++;
                else {
                    year++;
                    month = 1;
                }
                gvcal.setAdapter(new MonthView(getApplicationContext(), year, month, day));
                tvnow.setText(String.valueOf(months[month - 1] + " " + year));
            }
        });

        tvnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,YearActivity.class);
                i.putExtra("year",year);
                i.putExtra("month", month);
                startActivity(i);
            }
        });

        Button btnSet = (Button) findViewById(R.id.btnSettings);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,SettingsActivity.class);
                i.putExtra("year",year);
                i.putExtra("month", month);
                startActivity(i);
            }
        });
    }

    protected void onStop(){
        super.onStop();
        finish();
    }
}