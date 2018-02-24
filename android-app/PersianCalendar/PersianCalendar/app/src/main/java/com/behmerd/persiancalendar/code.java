package com.behmerd.persiancalendar;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class code {

    public static String toPersian(int Year, int Month, int Day)
    {
        return CPDate(Year, Month, Day);
    }

    public static String toPersian(String FullDate)
    {
        String[] dat = FullDate.split("/");
        if(dat.length<2)
            dat = FullDate.split("-");
        return CPDate(Integer.valueOf(dat[0]), Integer.valueOf(dat[1]), Integer.valueOf(dat[2]));
    }

    public static String toGregorian(int Year, int Month, int Day)
    {
        return CGDate(Year, Month, Day);
    }

    public static String toGregorian(String FullDate)
    {
        String[] dat = FullDate.split("/");
        if(dat.length<2)
            dat = FullDate.split("-");
        return CGDate(Integer.valueOf(dat[0]), Integer.valueOf(dat[1]), Integer.valueOf(dat[2]));
    }

    public static String getNow()
    {
        Calendar dat = Calendar.getInstance();
        return  toPersian(dat.get(Calendar.YEAR), dat.get(Calendar.MONTH) + 1, dat.get(Calendar.DAY_OF_MONTH));
    }

    public static int getYear()
    {
        String str;
        Calendar dat = Calendar.getInstance();
        str = toPersian(dat.get(Calendar.YEAR), dat.get(Calendar.MONTH)+1, dat.get(Calendar.DAY_OF_MONTH));
        str = str.substring(0, 4);
        return Integer.valueOf(str);
    }

    public static int getMonth()
    {
        String str;
        Calendar dat = Calendar.getInstance();
        str = toPersian(dat.get(Calendar.YEAR), dat.get(Calendar.MONTH)+1, dat.get(Calendar.DAY_OF_MONTH));
        str = str.substring(5, 7);
        return Integer.valueOf(str);
    }

    public static int getDay()
    {
        String str;
        Calendar dat = Calendar.getInstance();
        str = toPersian(dat.get(Calendar.YEAR), dat.get(Calendar.MONTH)+1, dat.get(Calendar.DAY_OF_MONTH));
        str = str.substring((str.length()-2), str.length());
        return Integer.valueOf(str);
    }

    public static int yearOf(int Year, int Month, int Day)
    {
        String str;
        str = toPersian(Year, Month, Day);
        str = str.substring(0, 4);
        return Integer.valueOf(str);
    }

    public static int monthOf(int Year, int Month, int Day)
    {
        String str;
        str = toPersian(Year, Month, Day);
        str = str.substring(5, 7);
        return Integer.valueOf(str);
    }

    public static int dayOf(int Year, int Month, int Day)
    {
        String str;
        str = toPersian(Year, Month, Day);
        str = str.substring((str.length()-2), str.length());
        return Integer.valueOf(str);
    }

    private static boolean IsLeapYearG(int Year)
    {
        if(Year%4 == 0)
        {
            if(Year%100 != 0)
                return true;
            else
                return (Year%400 == 0);
        }
        return false;
    }

    private static boolean IsLeapYearP(int Year)
    {
        int d, y;
        d = Year % 100;
        y = Year % 10;
        d -= y;
        d /= 10;
        if ((d == 1 || d == 3 || d == 5 || d == 7 || d == 9) && (y == 1 || y == 5 || y == 9))
            return true;
        else
            return ((d == 0 || d == 2 || d == 4 || d == 6 || d == 8) && (y == 3 || y == 7));
    }

    public static int getMaxDay(int year, int month)
    {
        int maxday;

        if(month>=1 && month<=6)
            maxday = 31;
        else if(month>=7 && month<=11)
            maxday = 30;
        else
            maxday = (IsLeapYearP(year)) ? 30 : 29;

        return maxday;
    }

    public static int getDayOfWeek(String fullDate)
    {
        Calendar dat = Calendar.getInstance();
        dat.setTime(stringToDate(toGregorian(fullDate),"MM/dd/yyyy"));
        int wd = dat.get(Calendar.DAY_OF_WEEK);
        if(wd==7)
            return 0;
        else
            return wd;
    }

    private static Date stringToDate(String aDate,String aFormat)
    {
        if(aDate==null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(aFormat);
        return simpledateformat.parse(aDate, pos);
    }

    private static String CPDate(int Year, int Month, int Day)
    {
        if (IsLeapYearG(Year))
            return cplyd(Year, Month, Day);
        else
            return cpnlyd(Year, Month, Day, IsLeapYearG(Year - 1));
    }

    private static String CGDate(int Year, int Month, int Day)
    {
        boolean L = false;
        if ((Month >= 1) && (Month <= 9))
            L = IsLeapYearG(Year + 621);
        else if (Month == 10)
        {
            if (IsLeapYearP(Year))
            {
                if ((Day >= 1) && (Day <= 11))
                    L = IsLeapYearG(Year + 621);
            }
            else
            {
                if ((Day >= 1) && (Day <= 10))
                    L = IsLeapYearG(Year + 621);
            }
        }
        else
            L = IsLeapYearG(Year + 622);
        if (L)
            return cglyd(Year, Month, Day);
        else
            return cgnlyd(Year, Month, Day, IsLeapYearP(Year));
    }

    private static String cpnlyd(int Year, int Month, int Day, boolean AL)
    {
        String datestr;
        switch(Month)
        {
            case 1:
                if(AL)
                {
                    if((Day >= 1) && (Day <= 19))
                    {
                        Day += 11;
                        Month += 9;
                    }
                    else if((Day >= 20) && (Day <= 31))
                    {
                        Day -= 19;
                        Month += 10;
                    }
                }
                else
                {
                    if((Day >= 1) && (Day <= 20))
                    {
                        Day += 10;
                        Month += 9;
                    }
                    else if((Day >= 21) && (Day <= 31))
                    {
                        Day -= 20;
                        Month += 10;
                    }
                }
                Year -= 622;
                break;
            case 2:
                if(AL)
                {
                    if((Day >= 1) && (Day <= 18))
                    {
                        Day += 12;
                        Month += 9;
                    }
                    else if((Day >= 19) && (Day <= 28))
                    {
                        Day -= 18;
                        Month += 10;
                    }
                }
                else
                {
                    if((Day >= 1) && (Day <= 19))
                    {
                        Day += 11;
                        Month += 9;
                    }
                    else if((Day >= 20) && (Day <= 28))
                    {
                        Day -= 19;
                        Month += 10;
                    }
                }
                Year -= 622;
                break;
            case 3:
                if((Day >= 1) && (Day <= 20))
                {
                    if(AL)
                    {
                        Day += 10;
                        Month += 9;
                    }
                    else
                    {
                        Day += 9;
                        Month += 9;
                    }
                    Year -= 622;
                }
                else if((Day >= 21) && (Day <= 31))
                {
                    Day -= 20;
                    Month -= 2;
                    Year -= 621;
                }
                break;
            case 4:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 11;
                    Month -= 3;
                }
                else if((Day >= 21) && (Day <= 30))
                {
                    Day -= 20;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 5:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 31))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 6:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 30))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 7:
                if((Day >= 1) && (Day <= 22))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 23) && (Day <= 31))
                {
                    Day -= 22;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 8:
                if((Day >= 1) && (Day <= 22))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 23) && (Day <= 31))
                {
                    Day -= 22;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 9:
                if((Day >= 1) && (Day <= 22))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 23) && (Day <= 30))
                {
                    Day -= 22;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 10:
                if((Day >= 1) && (Day <= 22))
                {
                    Day += 8;
                    Month -= 3;
                }
                else if((Day >= 23) && (Day <= 31))
                {
                    Day -= 22;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 11:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 30))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 12:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 31))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
        }

        datestr = String.valueOf(Year);
        datestr = datestr + "/";
        if(Month < 10)
            datestr = datestr + "0" + Month;
        else
            datestr = datestr + Month;

        datestr = datestr + "/";
        if(Day < 10)
            datestr = datestr + "0" + Day;
        else
            datestr = datestr + Day;

        return datestr;
    }

    private static String cplyd(int Year, int Month, int Day)
    {
        String datestr;
        switch(Month)
        {
            case 1:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 10;
                    Month += 9;
                }
                else if((Day >= 21) && (Day <= 31))
                {
                    Day -= 20;
                    Month += 10;
                }
                Year -= 622;
                break;
            case 2:
                if((Day >= 1) && (Day <= 19))
                {
                    Day += 11;
                    Month += 9;
                }
                else if((Day >= 20) && (Day <= 29))
                {
                    Day -= 19;
                    Month += 10;
                }
                Year -= 622;
                break;
            case 3:
                if((Day >= 1) && (Day <= 19))
                {
                    Day += 10;
                    Month += 9;
                    Year -= 622;
                }
                else if((Day >= 20) && (Day <= 31))
                {
                    Day -= 19;
                    Month -= 2;
                    Year -= 621;
                }
                break;
            case 4:
                if((Day >= 1) && (Day <= 19))
                {
                    Day += 12;
                    Month -= 3;
                }
                else if((Day >= 20) && (Day <= 30))
                {
                    Day -= 19;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 5:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 11;
                    Month -= 3;
                }
                else if((Day >= 21) && (Day <= 31))
                {
                    Day -= 20;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 6:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 11;
                    Month -= 3;
                }
                else if((Day >= 21) && (Day <= 30))
                {
                    Day -= 20;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 7:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 31))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 8:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 31))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 9:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 30))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 10:
                if((Day >= 1) && (Day <= 21))
                {
                    Day += 9;
                    Month -= 3;
                }
                else if((Day >= 22) && (Day <= 31))
                {
                    Day -= 21;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 11:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 21) && (Day <= 30))
                {
                    Day -= 20;
                    Month -= 2;
                }
                Year -= 621;
                break;
            case 12:
                if((Day >= 1) && (Day <= 20))
                {
                    Day += 10;
                    Month -= 3;
                }
                else if((Day >= 21) && (Day <= 31))
                {
                    Day -= 20;
                    Month -= 2;
                }
                Year -= 621;
                break;
        }


        datestr = String.valueOf(Year);
        datestr = datestr + "/";
        if(Month < 10)
            datestr = datestr + "0" + Month;
        else
            datestr = datestr + Month;

        datestr = datestr + "/";
        if(Day < 10)
            datestr = datestr + "0" + Day;
        else
            datestr = datestr + Day;

        return datestr;
    }

    private static String cgnlyd(int Year, int Month, int Day, boolean L)
    {
        String datestr;
        switch(Month)
        {
            case 1:
                if((Day >= 1) && (Day <= 11))
                {
                    Day += 20;
                    Month += 2;
                }
                else if((Day >= 12) && (Day <= 31))
                {
                    Day -= 11;
                    Month += 3;
                }
                Year += 621;
                break;
            case 2:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 20;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 31))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 3:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 31))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 4:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 31))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 5:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 22;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 31))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 6:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 22;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 31))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 7:
                if((Day >= 1) && (Day <= 8))
                {
                    Day += 22;
                    Month += 2;
                }
                else if((Day >= 9) && (Day <= 30))
                {
                    Day -= 8;
                    Month += 3;
                }
                Year += 621;
                break;
            case 8:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 22;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 30))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 9:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 30))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 10:
                if(L)
                {
                    if((Day >= 12) && (Day <= 30))
                    {
                        Day -= 11;
                        Month -= 9;
                        Year += 622;
                    }
                }
                else
                {
                    if((Day >= 1) && (Day <= 10))
                    {
                        Day += 21;
                        Month += 2;
                        Year += 621;
                    }
                    else if((Day >= 11) && (Day <= 30))
                    {
                        Day -= 10;
                        Month -= 9;
                        Year += 622;
                    }
                }
                break;
            case 11:
                if(L)
                {
                    if((Day >= 1) && (Day <= 12))
                    {
                        Day += 19;
                        Month -= 10;
                    }
                    else if((Day >= 13) && (Day <= 30))
                    {
                        Day -= 12;
                        Month -= 9;
                    }
                }
                else
                {
                    if((Day >= 1) && (Day <= 11))
                    {
                        Day += 20;
                        Month -= 10;
                    }
                    else if((Day >= 12) && (Day <= 30))
                    {
                        Day -= 11;
                        Month -= 9;
                    }
                }
                Year += 622;
                break;
            case 12:
                if(L)
                {
                    if((Day >= 1) && (Day <= 10))
                    {
                        Day += 18;
                        Month -= 10;
                    }
                    else if((Day >= 11) && (Day <= 30))
                    {
                        Day -= 10;
                        Month -= 9;
                    }
                }
                else
                {
                    if((Day >= 1) && (Day <= 9))
                    {
                        Day += 19;
                        Month -= 10;
                    }
                    else if((Day >= 10) && (Day <= 29))
                    {
                        Day -= 9;
                        Month -= 9;
                    }
                }
                Year += 622;
                break;
        }

        if(Month < 10)
            datestr = "0" + String.valueOf(Month);
        else
            datestr = String.valueOf(Month);

        datestr = datestr + "/";
        if(Day < 10)
            datestr = datestr + "0" + Day;
        else
            datestr = datestr + Day;

        datestr = datestr + "/";
        datestr = datestr + Year;

        return datestr;
    }

    private static String cglyd(int Year, int Month, int Day)
    {
        String datestr;
        switch(Month)
        {
            case 1:
                if((Day >= 1) && (Day <= 12))
                {
                    Day += 19;
                    Month += 2;
                }
                else if((Day >= 13) && (Day <= 31))
                {
                    Day -= 12;
                    Month += 3;
                }
                Year += 621;
                break;
            case 2:
                if((Day >= 1) && (Day <= 11))
                {
                    Day += 19;
                    Month += 2;
                }
                else if((Day >= 12) && (Day <= 31))
                {
                    Day -= 11;
                    Month += 3;
                }
                Year += 621;
                break;
            case 3:
                if((Day >= 1) && (Day <= 11))
                {
                    Day += 20;
                    Month += 2;
                }
                else if((Day >= 12) && (Day <= 31))
                {
                    Day -= 11;
                    Month += 3;
                }
                Year += 621;
                break;
            case 4:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 20;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 31))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 5:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 31))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 6:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 31))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 7:
                if((Day >= 1) && (Day <= 9))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 10) && (Day <= 30))
                {
                    Day -= 9;
                    Month += 3;
                }
                Year += 621;
                break;
            case 8:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 21;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 30))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 9:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 20;
                    Month += 2;
                }
                else if((Day >= 11) && (Day <= 30))
                {
                    Day -= 10;
                    Month += 3;
                }
                Year += 621;
                break;
            case 10:
                if((Day >= 1) && (Day <= 11) && (IsLeapYearP(Year)))
                {
                    Day += 20;
                    Month += 2;
                    Year += 621;
                }
                else if((Day >= 11) && (Day <= 30) && (!IsLeapYearP(Year)))
                {
                    Day -= 10;
                    Month -= 9;
                    Year += 622;
                }
                break;
            case 11:
                if((Day >= 1) && (Day <= 11))
                {
                    Day += 20;
                    Month -= 10;
                }
                else if((Day >= 12) && (Day <= 30))
                {
                    Day -= 11;
                    Month -= 9;
                }
                Year += 622;
                break;
            case 12:
                if((Day >= 1) && (Day <= 10))
                {
                    Day += 19;
                    Month -= 10;
                }
                else if((Day >= 11) && (Day <= 29))
                {
                    Day -= 10;
                    Month -= 9;
                }
                Year += 622;
                break;
        }

        if(Month < 10)
            datestr = "0" + String.valueOf(Month);
        else
            datestr = String.valueOf(Month);

        datestr = datestr + "/";
        if(Day < 10)
            datestr = datestr + "0" + Day;
        else
            datestr = datestr + Day;

        datestr = datestr + "/";
        datestr = datestr + Year;

        return datestr;
    }

}
