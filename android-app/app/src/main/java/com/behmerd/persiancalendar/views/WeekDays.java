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

public class WeekDays extends BaseAdapter{
    private String[] WeekDays;
    private Typeface typeface;
    private Context context;
    public WeekDays(Context context, String[] Days) {
        this.context = context;
        WeekDays = Days;
        typeface = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");
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
        Holder holder = null;
        if(convertView == null) {
            holder = new Holder();
            LayoutInflater inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.calendar_table_layout, parent, false);
            holder.tvDay = (TextView) convertView.findViewById(R.id.CTTVDay);
            holder.TopBar = (RelativeLayout) convertView.findViewById(R.id.CalendarTableCell);

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
            holder.tvDay.setTypeface(typeface);

            holder.tvDay.setText(WeekDays[position]);
        /*if(position==5)
            holder.tvDay.setTextColor(Color.parseColor(""));
        else */
            if(position == 6)
                holder.tvDay.setTextColor(context.getResources().getColor(R.color.holiday));
            else
                holder.tvDay.setTextColor(context.getResources().getColor(R.color.black));

        } catch (Exception e) {
            Log.e("WeekDaysView", "ERROR: " + e.getMessage());
        }

        return convertView;
    }

}
