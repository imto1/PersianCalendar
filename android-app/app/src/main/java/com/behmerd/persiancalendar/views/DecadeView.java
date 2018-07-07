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

import com.behmerd.persiancalendar.R;
import com.behmerd.persiancalendar.YearActivity;
import com.behmerd.persiancalendar.common.PersianCalendar;

public class DecadeView extends BaseAdapter {
    private Context context;
    private int currentYear, decade;
    private Typeface typeface;

    public DecadeView(Context context, int Year) {
        this.context = context;
        PersianCalendar calendar = new PersianCalendar();
        currentYear = calendar.Now.Year();
        decade = Year % 10;
        decade  = Year - decade;
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
        TextView tvYear;
        RelativeLayout cell;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if(convertView == null) {
            final Holder finalHolder = holder = new Holder();
            LayoutInflater inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.secondary_calendar_table_layout, parent, false);

            holder.tvYear = (TextView) convertView.findViewById(R.id.SCTVEntry);
            holder.cell = (RelativeLayout) convertView.findViewById(R.id.SecondaryCalendarTableCell);

            convertView.setTag(holder);
            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, YearActivity.class);
                    intent.putExtra("year", Integer.valueOf(finalHolder.tvYear.getText().toString()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        } else {
            holder = (Holder) convertView.getTag();
        }

        try {
            holder.tvYear.setTypeface(typeface);
            holder.tvYear.setText(String.valueOf(decade + position));
            if((decade + position) > (decade + 9))
                holder.tvYear.setTextColor(context.getResources().getColor(R.color.white));

            if(currentYear == (decade + position))
                holder.cell.setBackgroundColor(context.getResources().getColor(R.color.position));
        } catch (Exception e) {
            Log.e("DecadeView", "ERROR: " + e.getMessage());
        }

        return convertView;
    }
}
