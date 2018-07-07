package com.behmerd.persiancalendar.views;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.behmerd.persiancalendar.R;
import com.behmerd.persiancalendar.common.PersianCalendar;
import com.behmerd.persiancalendar.common.Preferences;
import com.behmerd.persiancalendar.common.TimeSheet;

import java.util.Arrays;

public class MonthView extends BaseAdapter{
    private int maxDays,dayOfWeek, dayOfMonth, weekDay, year, month, day, startingPosition;
    private boolean isMonthStarted, isMonthEnded, weekStartsOnMonthStart, TimeSheetEnabled;
    private Typeface boldFont, regularFont;
    private String[] rest;
    private PersianCalendar calendar;
    private Context context;

    public MonthView(Context context, int Year, int Month, int Day) {
        this.context = context;
        calendar = new PersianCalendar();
        year = Year;
        month = Month;
        day = Day;
        maxDays = calendar.Utilities.getMaxDay(year, month);
        dayOfWeek = calendar.Utilities.getDayOfWeek(year + "/" + month + "/1")+1;
        dayOfMonth = 1;
        weekDay = dayOfWeek;
        startingPosition = 0;
        weekStartsOnMonthStart = (dayOfWeek == 1);
        isMonthStarted = isMonthEnded = false;
        Preferences preferences = new Preferences(context);
        String TimeSheetRecord = preferences.getPWT();

        if(TimeSheetRecord != null){
            String[] TimeSheetData = TimeSheetRecord.split("~");
            TimeSheetEnabled = Boolean.valueOf(TimeSheetData[0]);
        } else
            TimeSheetEnabled = false;

        if(TimeSheetEnabled) {
            TimeSheet timesheet = new TimeSheet(context);
            rest = timesheet.getRestDays(Year, Month).split("~");
        }

        boldFont = Typeface.createFromAsset(context.getAssets(),"font/BNaznnBd.ttf");
        regularFont = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");
    }

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tvDay;
        TextView tvEvent;
        RelativeLayout cell;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null) {
            holder = new Holder();
            LayoutInflater inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.calendar_table_layout, parent, false);

            holder.tvDay=(TextView) convertView.findViewById(R.id.CTTVDay);
            holder.tvEvent=(TextView) convertView.findViewById(R.id.CTTVEntry);
            holder.cell=(RelativeLayout) convertView.findViewById(R.id.CalendarTableCell);

            convertView.setTag(holder);
            convertView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                }
            });
        } else {
            holder = (Holder) convertView.getTag();
        }

        try {
            holder.tvDay.setTypeface(boldFont);
            holder.tvEvent.setTypeface(regularFont);

            if(weekStartsOnMonthStart)
                if(position > startingPosition)
                    inc();

            if((position + 1) == weekDay)
                isMonthStarted = true;
            else if(dayOfMonth > maxDays)
                isMonthEnded = true;
            if(isMonthStarted && !isMonthEnded) {
                holder.tvDay.setText(String.valueOf(dayOfMonth));

                if(TimeSheetEnabled)
                    if (Arrays.asList(rest).contains(String.valueOf(dayOfMonth)))
                        holder.cell.setBackgroundColor(context.getResources().getColor(R.color.rest_day));

                if (dayOfWeek == 7)
                    holder.tvDay.setTextColor(context.getResources().getColor(R.color.holiday));
                else
                    holder.tvDay.setTextColor(context.getResources().getColor(R.color.black));

                int currentYear = calendar.Now.Year();
                int currentMonth = calendar.Now.Month();
                int currentDay = dayOfMonth;
                if(currentYear == year && currentMonth == month && currentDay == day)
                    holder.cell.setBackgroundColor(context.getResources().getColor(R.color.position));
                if(!weekStartsOnMonthStart)
                    inc();
            }
        } catch (Exception e) {
            Log.e("MonthView", "ERROR: " + e.getMessage());
        }

        return convertView;
    }

    private void inc(){
        if (dayOfWeek < 7)
            dayOfWeek++;
        else
            dayOfWeek = 1;
        ++dayOfMonth;
    }

}