package com.behmerd.persiancalendar;

import android.content.Context;

public class TimeSheet {
    private Context context;
    private static int wd; //work days on shared preferences
    private static int rd; //rest days on shared preferences
    private static int ty; //target year
    private static int tm; //target month
    private static int workStartDay; //final
    private static String ws; //work starting day on shared preferences

    public TimeSheet(Context context){
        this.context = context;
        SP sp = new SP(context);

        //get initial values from shared preferences
        String[] spData = sp.getPWT().split("~");
        wd = Integer.valueOf(spData[1]);
        rd = Integer.valueOf(spData[2]);
        ws = spData[3];
    }
    public static String getRestDays(int Year, int Month){
        int year ,month, day;

        ty=Year;
        tm=Month;
        days="";

        String[] wStart = ws.split("/");
        year = Integer.valueOf(wStart[0]);
        month = Integer.valueOf(wStart[1]);
        day = Integer.valueOf(wStart[2]);

        if((ty>year) ||(ty>=year && tm>=month)){
            wstart=workStartDay=day;

            if((year<ty)||(year<=ty && month<tm))
                navigate(year, month, day);

            calculate(ty,tm);
        }
        return days;
    }
    private static void navigate(int Year,int Month,int Day){ //recursive
        int max=code.getMaxDay(Year,Month);
        Day+=(wd+rd);
        if(Day>max) {
            Day -= max;
            Month++;
            if (Month > 12) {
                Month = 1;
                Year++;
            }
        }
        if((Year<ty)||(Year<=ty && Month<tm))
            navigate(Year,Month,Day);
        else if(Year==ty && Month==tm)
            wstart=workStartDay=Day;
    }
    private static void calculate(int Year,int Month){
        //extract rest days going backward
        backward(Year, Month);

        //extract rest days going foreward
        foreward(Year, Month);
    }

    private static  String days; //extracted rest days
    static int maxday; //maximum days in month
    static int rs,re; //rest start, rest end
    static int wstart; //work start

    private static void foreward(int Year,int Month) //recursive function for extract rest days going foreward
    {
        maxday = code.getMaxDay(Year,Month);
        int i;
        rs=wstart+wd;
        if(rs<=maxday){
            re=rs+rd;
            if(re>maxday)
                re=maxday+1;
            for(i=rs;i<re;i++)
                days+=String.valueOf(i)+"~"; //add rest day to rest list
            wstart=re;
            if(wstart<maxday)
                foreward(Year,Month);
        }
        //else
        wstart=workStartDay;
    }
    private static void backward(int Year,int Month) //recursive function for extract rest days going backward
    {
        int i;
        rs=wstart-1;
        if(rs>=1){
            re=rs-rd;
            if(re<1)
                re=0;
            for(i=rs;i>re;i--)
                days+=String.valueOf(i)+"~"; //add rest day to rest list
            wstart=re-wd;
            if(wstart>1)
                backward(Year,Month);
        }
        //else
        wstart=workStartDay;
    }
}
