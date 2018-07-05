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

    private Context context;
    private int max,dow, day, wd, cy, cm, cd, y, m, d, startingPosition;
    private boolean isMonthStarted, isMonthEnded, fomfow, tsheet;
    private Typeface fontB, fontR;
    private String[] rest;
    private PersianCalendar calendar;

    private static LayoutInflater inflater = null;
    public MonthView(Context cntx, int Year, int Month, int Day) {
        // TODO Auto-generated constructor stub
        context=cntx;
        calendar = new PersianCalendar();
        y=Year;
        m=Month;
        d=Day;
        max = calendar.Utilities.getMaxDay(y, m);
        dow = calendar.Utilities.getDayOfWeek(y + "/" + m + "/1")+1;
        day=1;
        wd=dow;
        startingPosition=0;
        fomfow=(dow==1);
        isMonthStarted = isMonthEnded = false;
        Preferences sp = new Preferences(context);
        String spd = sp.getPWT();
        String[] spData;
        if(spd != null){
            spData = spd.split("~");
            tsheet = Boolean.valueOf(spData[0]);
        } else
            tsheet=false;

        if(tsheet) {
            TimeSheet ts = new TimeSheet(context);
            rest = ts.getRestDays(Year, Month).split("~");
        }

        fontB = Typeface.createFromAsset(context.getAssets(),"font/BNaznnBd.ttf");
        fontR = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");

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
        TextView tvEv;
        TextView tvAp;
        RelativeLayout rlPanel;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.calendar_table_layout, null);
        holder.tvDay=(TextView) rowView.findViewById(R.id.tvDay);
        holder.tvEv=(TextView) rowView.findViewById(R.id.tvEvent);
        holder.tvAp=(TextView) rowView.findViewById(R.id.tvAppointment);
        holder.rlPanel=(RelativeLayout) rowView.findViewById(R.id.lPanel);

        holder.tvDay.setTypeface(fontB);
        holder.tvEv.setTypeface(fontR);
        holder.tvAp.setTypeface(fontR);

        if(fomfow)
            if(position>startingPosition)
                inc();

        if((position+1)==wd)
            isMonthStarted=true;
        else if(day>max)
            isMonthEnded = true;
        if(isMonthStarted && !isMonthEnded) {
            holder.tvDay.setText(String.valueOf(day));

            if(tsheet)
                if (Arrays.asList(rest).contains(String.valueOf(day)))
                    holder.rlPanel.setBackgroundColor(Color.parseColor("#00aa00"));//holder.rlPanel.setBackgroundResource(R.drawable.t);

            if (dow == 7)
                holder.tvDay.setTextColor(Color.parseColor("#ffaa00"));//holder.rlPanel.setBackgroundResource(R.drawable.f);
            else
                holder.tvDay.setTextColor(Color.parseColor("#ffffff"));//holder.rlPanel.setBackgroundResource(R.drawable.n);

            cy = calendar.Now.Year();
            cm = calendar.Now.Month();
            cd = day;
            if(cy==y && cm==m && cd==d)
                holder.rlPanel.setBackgroundColor(Color.parseColor("#00aaff"));
            if(!fomfow)
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
        if (dow < 7)
            dow++;
        else
            dow = 1;
        ++day;
    }

}