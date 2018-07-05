package com.behmerd.persiancalendar.common;

import android.content.Context;

public class TimeSheet {
    /**
     *      work --> work days in a period
     *      rest --> rest days in a period
     *      toYear --> target year in navigation
     *      toMonth --> target month in navigation
     *      periodStart --> first work day in a period
     *      restStart --> rest start
     *      restEnd --> rest end
     *      workStart--> work start
     *      timeData --> work starting day on shared preferences
     *      days --> extracted rest days
     */
    private int work, rest, toYear, toMonth, periodStart,
            restStart, restEnd, workStart;
    private String timeData, days;
    private PersianCalendar calendar;

    public TimeSheet(Context context){
        Preferences preferences = new Preferences(context);
        this.calendar = new PersianCalendar();

        //get initial values from shared preferences
        String[] data = preferences.getPWT().split("~");
        work = Integer.valueOf(data[1]);
        rest = Integer.valueOf(data[2]);
        timeData = data[3];
    }

    public String getRestDays(int Year, int Month){
        int year ,month, day;

        this.toYear = Year;
        this.toMonth = Month;
        this.days = "";

        String[] date = timeData.split("/");
        year = Integer.valueOf(date[0]);
        month = Integer.valueOf(date[1]);
        day = Integer.valueOf(date[2]);

        if((toYear > year) || (toYear >= year && toMonth >= month)){
            workStart = periodStart = day;

            if((year < toYear) || (year <= toYear && month < toMonth))
                navigate(year, month, day);

            calculate(toYear, toMonth);
        }
        return days;
    }

    private void navigate(int Year, int Month, int Day){ //recursive
        int max = calendar.Utilities.getMaxDay(Year, Month);
        Day += (work + rest);
        if(Day > max) {
            Day -= max;
            Month++;
            if (Month > 12) {
                Month = 1;
                Year++;
            }
        }
        if((Year < toYear ) || (Year <= toYear && Month < toMonth))
            navigate(Year, Month, Day);
        else if(Year == toYear && Month == toMonth)
            workStart = periodStart = Day;
    }

    private void calculate(int Year, int Month){
        //extract rest days going backward
        backward(Year, Month);

        //extract rest days going forward
        forward(Year, Month);
    }

    //recursive function for extract rest days going forward
    private void forward(int Year, int Month)
    {
        int maxDays = calendar.Utilities.getMaxDay(Year, Month);
        int i;
        restStart = workStart + work;
        if(restStart <= maxDays){
            restEnd = restStart + rest;
            if(restEnd > maxDays)
                restEnd = maxDays + 1;
            for(i=restStart;i<restEnd;i++)
                days += String.valueOf(i) + "~"; //add rest day to rest list
            workStart = restEnd;
            if(workStart < maxDays)
                forward(Year, Month);
        }
        //else
        workStart = periodStart;
    }

    //recursive function for extract rest days going backward
    private void backward(int Year, int Month)
    {
        int i;
        restStart = workStart - 1;
        if(restStart >= 1){
            restEnd = restStart - rest;
            if(restEnd < 1)
                restEnd = 0;
            for(i=restStart;i>restEnd;i--)
                days += String.valueOf(i) + "~"; //add rest day to rest list
            workStart = restEnd - work;
            if(workStart > 1)
                backward(Year, Month);
        }
        //else
        workStart = periodStart;
    }
}
