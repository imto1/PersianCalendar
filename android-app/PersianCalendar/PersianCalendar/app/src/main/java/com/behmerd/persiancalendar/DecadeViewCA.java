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

public class DecadeViewCA extends BaseAdapter {

    private Context context;
    private int y, cy, decade;
    private Typeface tf;

    private static LayoutInflater inflater=null;
    public DecadeViewCA(Context cntx, int Year) {
        // TODO Auto-generated constructor stub
        context=cntx;
        y = Year;
        cy = code.getYear();
        decade=y%10;
        decade=y-decade;
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
        TextView tvYear;
        RelativeLayout rlPanel;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.yearview_table_layout, null);
        holder.tvYear=(TextView) rowView.findViewById(R.id.tvMonth);
        holder.rlPanel=(RelativeLayout) rowView.findViewById(R.id.lPanel);
        holder.tvYear.setTypeface(tf);

        //Typeface fontB = Typeface.createFromAsset(getAssets(),"font/BNaznnBd.ttf");
        //Typeface fontR = Typeface.createFromAsset(getAssets(),"font/BNazanin.ttf");

            holder.tvYear.setText(String.valueOf(decade + position));
            if((decade+position)>(decade+9))
                holder.tvYear.setTextColor(Color.parseColor("#444444"));

        if(cy==(decade+position))
            holder.rlPanel.setBackgroundColor(Color.parseColor("#00aaff"));

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(context,YearActivity.class);
                i.putExtra("year",Integer.valueOf(holder.tvYear.getText().toString()));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });

        return rowView;
    }
}
