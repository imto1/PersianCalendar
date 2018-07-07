package com.behmerd.persiancalendar.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
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
    private int year, currentYear, currentMonth;
    private String[] monthList;
    private Typeface typeface;

    public YearView(Context context, int Year, String[] Months) {
        this.context = context;
        year = Year;
        monthList = Months;
        PersianCalendar calendar = new PersianCalendar();
        currentYear = calendar.Now.Year();
        currentMonth = calendar.Now.Month();
        typeface = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");
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
        Holder holder = null;
        if(convertView == null) {
            final Holder finalHolder = holder = new Holder();
            LayoutInflater inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.yearview_table_layout, parent, false);
            holder.tvMonth=(TextView) convertView.findViewById(R.id.tvMonth);
            holder.TopBar=(RelativeLayout) convertView.findViewById(R.id.lPanel);

            convertView.setTag(holder);
            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int selectedMonth = 1;
                    if(Arrays.asList(monthList).contains(finalHolder.tvMonth.getText().toString()))
                        selectedMonth = (Arrays.asList(monthList).
                                indexOf(finalHolder.tvMonth.getText().toString())) + 1;
                    Intent intent = new Intent(context,MainActivity.class);
                    intent.putExtra("year", year);
                    intent.putExtra("month", selectedMonth);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        } else {
            holder = (Holder) convertView.getTag();
        }

        try {
            holder.tvMonth.setTypeface(typeface);
            holder.tvMonth.setText(monthList[position]);

            int month = position + 1;
            if(currentYear == year && currentMonth == month)
                holder.TopBar.setBackgroundColor(Color.parseColor("#00aaff"));
        } catch (Exception e) {
            Log.e("YearView", "ERROR: " + e.getMessage());
        }

        return convertView;
    }
}
