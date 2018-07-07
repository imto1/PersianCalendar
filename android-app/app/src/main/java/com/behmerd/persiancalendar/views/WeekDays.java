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

public class WeekDays extends BaseAdapter{
    private String[] WeekDays;
    private static LayoutInflater inflater = null;
    private Typeface typeface;
    public WeekDays(Context context, String[] Days) {
        WeekDays = Days;
        typeface = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 7;
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
        RelativeLayout TopBar;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.calendar_table_layout, null);
        holder.tvDay = (TextView) rowView.findViewById(R.id.tvDay);
        holder.TopBar = (RelativeLayout) rowView.findViewById(R.id.lPanel);
        holder.tvDay.setTypeface(typeface);

        holder.tvDay.setText(WeekDays[position]);
        /*if(position==5)
            holder.tvDay.setTextColor(Color.parseColor("#00aaff"));
        else */
        if(position == 6)
            holder.tvDay.setTextColor(Color.parseColor("#ffaa00"));
        else
            holder.tvDay.setTextColor(Color.parseColor("#ffffff"));

        rowView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            }
        });

        return rowView;
    }

}
