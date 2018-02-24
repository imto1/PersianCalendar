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

public class MainActivity extends Activity {

    int m,y,d;
    String[] months;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridView gvcal=(GridView) findViewById(R.id.gvCalendar);
        GridView gvwd=(GridView) findViewById(R.id.gvWD);
        final TextView tvnow = (TextView) findViewById(R.id.tvNow);
        ImageView ivup = (ImageView) findViewById(R.id.ivU);
        ImageView ivduown = (ImageView) findViewById(R.id.ivDY);
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");
        tvnow.setTypeface(tf);


        if(getIntent().getExtras() != null){
            y = getIntent().getExtras().getInt("year");
            m = getIntent().getExtras().getInt("month");
        }
        else {
            m = code.getMonth();
            y = code.getYear();
        }
        d = code.getDay();

        months=getResources().getStringArray(R.array.monthList);

        tvnow.setText(String.valueOf(months[m - 1] + " " + y));

        gvwd.setAdapter(new WeekDaysCA(this, getResources().getString(R.string.wds).split("~")));
        gvcal.setAdapter(new MonthViewCA(getApplicationContext(), y, m, d));

        ivup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m > 1)
                    m--;
                else {
                    y--;
                    m = 12;
                }
                gvcal.setAdapter(new MonthViewCA(getApplicationContext(), y, m, d));
                tvnow.setText(String.valueOf(months[m - 1] + " " + y));
            }
        });

        ivduown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m < 12)
                    m++;
                else {
                    y++;
                    m = 1;
                }
                gvcal.setAdapter(new MonthViewCA(getApplicationContext(), y, m, d));
                tvnow.setText(String.valueOf(months[m - 1] + " " + y));
            }
        });

        tvnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,YearActivity.class);
                i.putExtra("year",y);
                i.putExtra("month", m);
                startActivity(i);
            }
        });

        Button btnSet = (Button) findViewById(R.id.btnSettings);
        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,SettingsActivity.class);
                i.putExtra("year",y);
                i.putExtra("month",m);
                startActivity(i);
            }
        });
    }

    protected void onStop(){
        super.onStop();
        finish();
    }
}