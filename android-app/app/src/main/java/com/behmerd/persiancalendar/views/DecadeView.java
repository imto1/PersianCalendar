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

import com.behmerd.persiancalendar.R;
import com.behmerd.persiancalendar.YearActivity;
import com.behmerd.persiancalendar.common.PersianCalendar;

public class DecadeView extends BaseAdapter {

    private Context context;
    private int year, currentYear, decade;
    private Typeface typeface;

    private static LayoutInflater inflater=null;
    public DecadeView(Context context, int Year) {
        this.context = context;
        PersianCalendar calendar = new PersianCalendar();
        year = Year;
        currentYear = calendar.Now.Year();
        decade = year % 10;
        decade  = year - decade;
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
        TextView tvYear;
        RelativeLayout rlPanel;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.yearview_table_layout, null);
        holder.tvYear = (TextView) rowView.findViewById(R.id.tvMonth);
        holder.rlPanel = (RelativeLayout) rowView.findViewById(R.id.lPanel);
        holder.tvYear.setTypeface(typeface);

        //Typeface fontB = Typeface.createFromAsset(getAssets(),"font/BNaznnBd.ttf");
        //Typeface fontR = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");

            holder.tvYear.setText(String.valueOf(decade + position));
            if((decade + position) > (decade + 9))
                holder.tvYear.setTextColor(Color.parseColor("#444444"));

        if(currentYear == (decade + position))
            holder.rlPanel.setBackgroundColor(Color.parseColor("#00aaff"));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YearActivity.class);
                intent.putExtra("year", Integer.valueOf(holder.tvYear.getText().toString()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
