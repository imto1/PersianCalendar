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

    int y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);

        final GridView gvmc = (GridView) findViewById(R.id.gvMC);
        final TextView tvnow = (TextView) findViewById(R.id.tvMonth);
        ImageView ivup = (ImageView) findViewById(R.id.ivUM);
        ImageView ivduown = (ImageView) findViewById(R.id.ivDY);
        final String[] month = getResources().getStringArray(R.array.monthList);
        Typeface tf = Typeface.createFromAsset(getAssets(), "font/BNazanin.ttf");
        tvnow.setTypeface(tf);

        PersianCalendar calendar = new PersianCalendar();
        if(getIntent().getExtras() != null)
            y = getIntent().getExtras().getInt("year");
        else
            y = calendar.Now.Year();

        tvnow.setText(String.valueOf(y));

        gvmc.setAdapter(new YearView(getApplicationContext(), y, month));

        ivup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y--;
                gvmc.setAdapter(new YearView(getApplicationContext(), y, month));
                tvnow.setText(String.valueOf(y));
            }
        });

        ivduown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y++;
                gvmc.setAdapter(new YearView(getApplicationContext(), y, month));
                tvnow.setText(String.valueOf(y));
            }
        });

        tvnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(YearActivity.this,DecadeActivity.class);
                i.putExtra("year",y);
                startActivity(i);
            }
        });
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}