package com.behmerd.persiancalendar;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class DecadeActivity extends Activity {

    private int y,decade;

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

        if(getIntent().getExtras() != null)
            y = getIntent().getExtras().getInt("year");
        else
            y = code.getYear();

        decade=y%10;
        decade=y-decade;
        tvnow.setText(String.valueOf(decade+9) + " - " + String.valueOf(decade));

        gvmc.setAdapter(new DecadeViewCA(getApplicationContext(), y));

        ivup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y-=10;
                gvmc.setAdapter(new DecadeViewCA(getApplicationContext(), y));
                decade=y%10;
                decade=y-decade;
                tvnow.setText(String.valueOf(decade+9) + " - " + String.valueOf(decade));
            }
        });

        ivduown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y+=10;
                gvmc.setAdapter(new DecadeViewCA(getApplicationContext(), y));
                decade=y%10;
                decade=y-decade;
                tvnow.setText(String.valueOf(decade+9) + " - " + String.valueOf(decade));
            }
        });
    }

    protected void onStop() {
        super.onStop();
        finish();
    }
}
