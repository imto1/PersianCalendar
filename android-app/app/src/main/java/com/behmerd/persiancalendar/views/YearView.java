package com.behmerd.persiancalendar.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.behmerd.persiancalendar.MainActivity;
import com.behmerd.persiancalendar.R;
import com.behmerd.persiancalendar.common.PersianCalendar;

import java.util.Arrays;

public class YearView extends BaseAdapter {

    private Context context;
    private int year, month, currentYear, currentMonth;
    private String[] monthList;
    private Typeface typeface;

    private static LayoutInflater inflater=null;
    public YearView(Context context, int Year, String[] Months) {
        this.context = context;
        year = Year;
        monthList = Months;
        PersianCalendar calendar = new PersianCalendar();
        currentYear = calendar.Now.Year();
        currentMonth = calendar.Now.Month();

        typeface = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 12;
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
        TextView tvMonth;
        RelativeLayout TopBar;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.yearview_table_layout, null);
        holder.tvMonth=(TextView) rowView.findViewById(R.id.tvMonth);
        holder.TopBar=(RelativeLayout) rowView.findViewById(R.id.lPanel);
        holder.tvMonth.setTypeface(typeface);


        holder.tvMonth.setText(monthList[position]);

        month = position + 1;
        if(currentYear == year && currentMonth == month)
            holder.TopBar.setBackgroundColor(Color.parseColor("#00aaff"));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int selectedMonth = 1;
                if(Arrays.asList(monthList).contains(holder.tvMonth.getText().toString()))
                  selectedMonth = (Arrays.asList(monthList).indexOf(holder.tvMonth.getText().toString())) + 1;
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtra("year", year);
                intent.putExtra("month", selectedMonth);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
