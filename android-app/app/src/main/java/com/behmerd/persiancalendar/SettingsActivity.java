package com.behmerd.persiancalendar;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.behmerd.persiancalendar.common.Preferences;


public class SettingsActivity extends Activity {

    boolean TimeSheetEnabled;
    int month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //layout objects
        final Button btnSave = (Button) findViewById(R.id.btnSave);
        final EditText etWork = (EditText) findViewById(R.id.etWork);
        final EditText etRest = (EditText) findViewById(R.id.etRest);
        final EditText etDay = (EditText) findViewById(R.id.etDayTS);
        final EditText etMonth = (EditText) findViewById(R.id.etMonthTS);
        final EditText etYear = (EditText) findViewById(R.id.etYearTS);
        final LinearLayout llWorkAndRest = (LinearLayout) findViewById(R.id.llWaRDays);
        final LinearLayout llStartDate = (LinearLayout) findViewById(R.id.llsDate);
        final TextView tvWorkAndRest = (TextView) findViewById(R.id.tvWaR);
        final TextView tvStartDate = (TextView) findViewById(R.id.tvStartDate);
        TextView tvTitle = (TextView) findViewById(R.id.tvSTitle);
        TextView tvWork = (TextView) findViewById(R.id.tvWork);
        TextView tvRest = (TextView) findViewById(R.id.tvRest);
        TextView tvDay = (TextView) findViewById(R.id.tvDayTS);
        TextView tvMonth = (TextView) findViewById(R.id.tvMonthTS);
        TextView tvYear = (TextView) findViewById(R.id.tvYearTS);
        Switch TimeSheetSwitch = (Switch) findViewById(R.id.opTimeSheet);


        Typeface fontB = Typeface.createFromAsset(getAssets(), "font/BNaznnBd.ttf");
        Typeface fontR = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");

        etWork.setTypeface(fontR);
        etRest.setTypeface(fontR);
        etDay.setTypeface(fontR);
        etMonth.setTypeface(fontR);
        etYear.setTypeface(fontR);
        tvWork.setTypeface(fontR);
        tvRest.setTypeface(fontR);
        tvDay.setTypeface(fontR);
        tvMonth.setTypeface(fontR);
        tvYear.setTypeface(fontR);
        btnSave.setTypeface(fontR);
        tvWorkAndRest.setTypeface(fontB);
        tvStartDate.setTypeface(fontB);
        TimeSheetSwitch.setTypeface(fontR);
        tvTitle.setTypeface(fontB);

        if(getIntent().getExtras() != null){
            year = getIntent().getExtras().getInt("year");
            month = getIntent().getExtras().getInt("month");
            etYear.setText(String.valueOf(year));
            etMonth.setText(String.valueOf(month));
        }

        final Preferences sp = new Preferences(getApplicationContext());
        String spd = sp.getPWT();
        if(spd != null){
            String[] spD = spd.split("~");
            TimeSheetEnabled = Boolean.valueOf(spD[0]);
            TimeSheetSwitch.setChecked(TimeSheetEnabled);
            if (TimeSheetEnabled) {
                llWorkAndRest.setVisibility(View.VISIBLE);
                llStartDate.setVisibility(View.VISIBLE);
                tvWorkAndRest.setVisibility(View.VISIBLE);
                tvStartDate.setVisibility(View.VISIBLE);
            }
            etWork.setText(spD[1]);
            etRest.setText(spD[2]);
            String[] spDS = spD[3].split("/");
            etYear.setText(spDS[0]);
            etMonth.setText(spDS[1]);
            etDay.setText(spDS[2]);
        }

        TimeSheetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llWorkAndRest.setVisibility(View.VISIBLE);
                    llStartDate.setVisibility(View.VISIBLE);
                    tvWorkAndRest.setVisibility(View.VISIBLE);
                    tvStartDate.setVisibility(View.VISIBLE);
                } else {
                    llWorkAndRest.setVisibility(View.INVISIBLE);
                    llStartDate.setVisibility(View.INVISIBLE);
                    tvWorkAndRest.setVisibility(View.INVISIBLE);
                    tvStartDate.setVisibility(View.INVISIBLE);
                }
                TimeSheetEnabled = isChecked;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isSaved = sp.setPWT(TimeSheetEnabled, etWork.getText().toString(), etRest.getText().toString(),
                        (etYear.getText().toString() + "/" + etMonth.getText().toString() + "/" + etDay.getText().toString()));
                if (isSaved) {
                    Toast.makeText(SettingsActivity.this, "Settings are saved!", Toast.LENGTH_LONG).show();
                    Intent i= new Intent(SettingsActivity.this,MainActivity.class);
                    i.putExtra("year", year);
                    i.putExtra("month", month);
                    startActivity(i);
                }
            }
        });
    }

    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
    }
    protected void onStop(){
        super.onStop();
        finish();
    }
}
