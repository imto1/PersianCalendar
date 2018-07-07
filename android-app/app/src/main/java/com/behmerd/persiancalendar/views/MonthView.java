package com.behmerd.persiancalendar.views;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

    private static LayoutInflater inflater = null;
    public MonthView(Context context, int Year, int Month, int Day) {
        // TODO Auto-generated constructor stub
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

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 42;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tvDay;
        TextView tvEvent;
        TextView tvAppointment;
        RelativeLayout TopBar;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.calendar_table_layout, null);
        holder.tvDay=(TextView) rowView.findViewById(R.id.tvDay);
        holder.tvEvent=(TextView) rowView.findViewById(R.id.tvEvent);
        holder.tvAppointment=(TextView) rowView.findViewById(R.id.tvAppointment);
        holder.TopBar=(RelativeLayout) rowView.findViewById(R.id.lPanel);

        holder.tvDay.setTypeface(boldFont);
        holder.tvEvent.setTypeface(regularFont);
        holder.tvAppointment.setTypeface(regularFont);

        if(weekStartsOnMonthStart)
            if(position>startingPosition)
                inc();

        if((position+1)==weekDay)
            isMonthStarted=true;
        else if(dayOfMonth>maxDays)
            isMonthEnded = true;
        if(isMonthStarted && !isMonthEnded) {
            holder.tvDay.setText(String.valueOf(dayOfMonth));

            if(TimeSheetEnabled)
                if (Arrays.asList(rest).contains(String.valueOf(dayOfMonth)))
                    holder.TopBar.setBackgroundColor(Color.parseColor("#00aa00"));//holder.TopBar.setBackgroundResource(R.drawable.t);

            if (dayOfWeek == 7)
                holder.tvDay.setTextColor(Color.parseColor("#ffaa00"));//holder.TopBar.setBackgroundResource(R.drawable.f);
            else
                holder.tvDay.setTextColor(Color.parseColor("#ffffff"));//holder.TopBar.setBackgroundResource(R.drawable.n);

            int currentYear = calendar.Now.Year();
            int currentMonth = calendar.Now.Month();
            int currentDay = dayOfMonth;
            if(currentYear == year && currentMonth == month && currentDay == day)
                holder.TopBar.setBackgroundColor(Color.parseColor("#00aaff"));
            if(!weekStartsOnMonthStart)
                inc();
        }

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+(holder.tvDay.getText().toString()), Toast.LENGTH_LONG).show();
            }
        });

        return rowView;
    }

    private void inc(){
        if (dayOfWeek < 7)
            dayOfWeek++;
        else
            dayOfWeek = 1;
        ++dayOfMonth;
    }

}