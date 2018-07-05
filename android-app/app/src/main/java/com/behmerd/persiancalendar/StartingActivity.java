package com.behmerd.persiancalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.widget.TextView;

import com.behmerd.persiancalendar.common.PersianCalendar;

public class StartingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        PersianCalendar calendar = new PersianCalendar();
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(calendar.Now.Today() + "\n" + calendar.Now.Year() + "\n" + calendar.Now.Month() +
                "\n" + calendar.Now.Day() + "\n" + calendar.Convert.toPersian("1-19-1987") + "\n" +
                calendar.Convert.toPersian(1987,1,19) + "\n" + calendar.Utilities.getYearOf(1987, 1, 19) +
                "\n" + calendar.Utilities.getMonthOf(1987, 1, 19)  + "\n" +
                calendar.Utilities.getDayOf(1987,1,19)  + "\n" + calendar.Convert.toGregorian("1365-10-29") +
                "\n" + calendar.Convert.toGregorian(1365,10,29));


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
