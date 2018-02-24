package com.behmerd.persiancalendar;

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

import java.util.Arrays;

public class YearViewCA extends BaseAdapter {

    private Context context;
    private int y, m, cy, cm;
    private String[] mnt;
    private Typeface tf;

    private static LayoutInflater inflater=null;
    public YearViewCA(Context cntx, int Year, String[] Months) {
        // TODO Auto-generated constructor stub
        context=cntx;
        y = Year;
        mnt = Months;
        cy = code.getYear();
        cm = code.getMonth();

        tf = Typeface.createFromAsset(context.getAssets(),"font/BNazanin.ttf");

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 12;
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
        TextView tvMonth;
        RelativeLayout rlPanel;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.yearview_table_layout, null);
        holder.tvMonth=(TextView) rowView.findViewById(R.id.tvMonth);
        holder.rlPanel=(RelativeLayout) rowView.findViewById(R.id.lPanel);
        holder.tvMonth.setTypeface(tf);


        holder.tvMonth.setText(mnt[position]);

        m = position+1;
        if(cy==y && cm==m)
            holder.rlPanel.setBackgroundColor(Color.parseColor("#00aaff"));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                int selectedMonth = 1;
                if(Arrays.asList(mnt).contains(holder.tvMonth.getText().toString()))
                  selectedMonth = (Arrays.asList(mnt).indexOf(holder.tvMonth.getText().toString()))+1;
                Intent i = new Intent(context,MainActivity.class);
                i.putExtra("year",y);
                i.putExtra("month", selectedMonth);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        return rowView;
    }
}
