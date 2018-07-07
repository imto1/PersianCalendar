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
        final GridView gvCalendar = (GridView) findViewById(R.id.mainGVCalendar);
        GridView gvWeekDays = (GridView) findViewById(R.id.mainGVWeekDays);
        final TextView tvNow = (TextView) findViewById(R.id.mainTVNow);
        ImageView ivUp = (ImageView) findViewById(R.id.mainIVUp);
        ImageView ivDown = (ImageView) findViewById(R.id.mainIVDown);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");
        tvNow.setTypeface(typeface);


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

        tvNow.setText(String.valueOf(months[month - 1] + " " + year));

        gvWeekDays.setAdapter(new WeekDays(this, getResources().getString(R.string.wds).split("~")));
        gvCalendar.setAdapter(new MonthView(getApplicationContext(), year, month, day));

        ivUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month > 1)
                    month--;
                else {
                    year--;
                    month = 12;
                }
                gvCalendar.setAdapter(new MonthView(getApplicationContext(), year, month, day));
                tvNow.setText(String.valueOf(months[month - 1] + " " + year));
            }
        });

        ivDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (month < 12)
                    month++;
                else {
                    year++;
                    month = 1;
                }
                gvCalendar.setAdapter(new MonthView(getApplicationContext(), year, month, day));
                tvNow.setText(String.valueOf(months[month - 1] + " " + year));
            }
        });

        tvNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,YearActivity.class);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                startActivity(intent);
            }
        });

        Button btnSet = (Button) findViewById(R.id.btnSettings);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SettingsActivity.class);
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                startActivity(intent);
            }
        });
    }

    protected void onStop(){
        super.onStop();
        finish();
    }
}