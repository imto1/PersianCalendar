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

    boolean isTSEnabled;
    int m,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //layout objects
        final Button btnSave = (Button) findViewById(R.id.btnSave);
        final EditText etW = (EditText) findViewById(R.id.etWork);
        final EditText etR = (EditText) findViewById(R.id.etRest);
        final EditText etD = (EditText) findViewById(R.id.etDayTS);
        final EditText etM = (EditText) findViewById(R.id.etMonthTS);
        final EditText etY = (EditText) findViewById(R.id.etYearTS);
        final LinearLayout llWaR = (LinearLayout) findViewById(R.id.llWaRDays);
        final LinearLayout llsDate = (LinearLayout) findViewById(R.id.llsDate);
        final TextView tvWaR = (TextView) findViewById(R.id.tvWaR);
        final TextView tvsDate = (TextView) findViewById(R.id.tvStartDate);
        TextView tvTitle = (TextView) findViewById(R.id.tvSTitle);
        TextView tvW = (TextView) findViewById(R.id.tvWork);
        TextView tvR = (TextView) findViewById(R.id.tvRest);
        TextView tvD = (TextView) findViewById(R.id.tvDayTS);
        TextView tvM = (TextView) findViewById(R.id.tvMonthTS);
        TextView tvY = (TextView) findViewById(R.id.tvYearTS);
        Switch op = (Switch) findViewById(R.id.opTimeSheet);


        Typeface fontB = Typeface.createFromAsset(getAssets(), "font/BNaznnBd.ttf");
        Typeface fontR = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");

        etW.setTypeface(fontR);
        etR.setTypeface(fontR);
        etD.setTypeface(fontR);
        etM.setTypeface(fontR);
        etY.setTypeface(fontR);
        tvW.setTypeface(fontR);
        tvR.setTypeface(fontR);
        tvD.setTypeface(fontR);
        tvM.setTypeface(fontR);
        tvY.setTypeface(fontR);
        btnSave.setTypeface(fontR);
        tvWaR.setTypeface(fontB);
        tvsDate.setTypeface(fontB);
        op.setTypeface(fontR);
        tvTitle.setTypeface(fontB);

        if(getIntent().getExtras() != null){
            y = getIntent().getExtras().getInt("year");
            m = getIntent().getExtras().getInt("month");
            etY.setText(String.valueOf(y));
            etM.setText(String.valueOf(m));
        }

        final Preferences sp = new Preferences(getApplicationContext());
        String spd = sp.getPWT();
        if(spd != null){
            String[] spD = spd.split("~");
            isTSEnabled = Boolean.valueOf(spD[0]);
            op.setChecked(isTSEnabled);
            if (isTSEnabled) {
                llWaR.setVisibility(View.VISIBLE);
                llsDate.setVisibility(View.VISIBLE);
                tvWaR.setVisibility(View.VISIBLE);
                tvsDate.setVisibility(View.VISIBLE);
            }
            etW.setText(spD[1]);
            etR.setText(spD[2]);
            String[] spDS = spD[3].split("/");
            etY.setText(spDS[0]);
            etM.setText(spDS[1]);
            etD.setText(spDS[2]);
        }

        op.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    llWaR.setVisibility(View.VISIBLE);
                    llsDate.setVisibility(View.VISIBLE);
                    tvWaR.setVisibility(View.VISIBLE);
                    tvsDate.setVisibility(View.VISIBLE);
                } else {
                    llWaR.setVisibility(View.INVISIBLE);
                    llsDate.setVisibility(View.INVISIBLE);
                    tvWaR.setVisibility(View.INVISIBLE);
                    tvsDate.setVisibility(View.INVISIBLE);
                }
                isTSEnabled = isChecked;
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isSaved = sp.setPWT(isTSEnabled, etW.getText().toString(), etR.getText().toString(),
                        (etY.getText().toString() + "/" + etM.getText().toString() + "/" + etD.getText().toString()));
                if (isSaved) {
                    Toast.makeText(SettingsActivity.this, "Settings are saved!", Toast.LENGTH_LONG).show();
                    Intent i= new Intent(SettingsActivity.this,MainActivity.class);
                    i.putExtra("year",y);
                    i.putExtra("month", m);
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
