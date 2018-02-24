package com.behmerd.persiancalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.widget.TextView;

public class StartingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(code.getNow() + "\n" + code.getYear() + "\n" + code.getMonth() + "\n" +
                code.getDay() + "\n" + code.toPersian("1-19-1987") + "\n" + code.toPersian(1987,1,19) + "\n" +
                code.yearOf(1987,1,19) + "\n" + code.monthOf(1987,1,19)  + "\n" + code.dayOf(1987,1,19)  + "\n" +
        code.toGregorian("1365-10-29") + "\n" + code.toGregorian(1365,10,29));


        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(new Intent(StartingActivity.this,MainActivity.class));
            }
        }.start();
    }

    protected void onStop(){
        super.onStop();
        finish();
    }
}
