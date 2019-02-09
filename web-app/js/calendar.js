/*

██╗███╗   ███╗████████╗ ██████╗  ██╗
██║████╗ ████║╚══██╔══╝██╔═══██╗███║
██║██╔████╔██║   ██║   ██║   ██║╚██║
██║██║╚██╔╝██║   ██║   ██║   ██║ ██║
██║██║ ╚═╝ ██║   ██║   ╚██████╔╝ ██║
╚═╝╚═╝     ╚═╝   ╚═╝    ╚═════╝  ╚═╝

*/

function toPersian(Year, Month, Day)
{
    if (GregorianLeapYear(Year))
        return ConvertPersianDate_Leap(Year, Month, Day);
    else
        return ConvertPersianDate_NotLeap(Year, Month, Day, GregorianLeapYear(Year - 1));
}

function toPersianByStr(FullDate)
{
    var date = [];
    date = SplitDate(FullDate);
    return toPersian(Number(date[0]), Number(date[1]), Number(date[2]));
}

function toGregorian(Year, Month, Day)
{
    var L = false;
    if ((Month >= 1) && (Month <= 9))
        L = GregorianLeapYear(Year + 621);
    else if (Month == 10)
    {
        if (PersianLeapYear(Year))
        {
            if ((Day >= 1) && (Day <= 11))
                L = GregorianLeapYear(Year + 621);
        }
        else
        {
            if ((Day >= 1) && (Day <= 10))
                L = GregorianLeapYear(Year + 621);
        }
    }
    else
        L = GregorianLeapYear(Year + 622);
    if (L)
        return ConvertGregorianDate_Leap(Year, Month, Day);
    else
        return ConvertGregorianDate_NotLeap(Year, Month, Day, PersianLeapYear(Year));
}

function toGregorianByStr(FullDate)
{
    var date = [];
    date = SplitDate(FullDate);
    return toGregorian(Number(date[0]), Number(date[1]), Number(date[2]));
}

function ConvertPersianDate_NotLeap(Year, Month, Day, AL)
{
    var datestr = "";
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

    datestr += Year;
    datestr += "/";
    if(Month < 10)
        datestr += "0" + Month;
    else
        datestr += Month;

    datestr += "/";
    if(Day < 10)
        datestr += "0" + Day;
    else
        datestr += Day;

    return datestr;
}

function ConvertPersianDate_Leap(Year, Month, Day)
{
    var datestr = "";
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


    datestr += Year;
    datestr += "/";
    if(Month < 10)
        datestr += "0" + Month;
    else
        datestr += Month;

    datestr += "/";
    if(Day < 10)
        datestr += "0" + Day;
    else
        datestr += Day;

    return datestr;
}

function ConvertGregorianDate_NotLeap(Year, Month, Day, L)
{
    var datestr = "";
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
        datestr += "0" + Month;
    else
        datestr += Month;

    datestr += "/";
    if(Day < 10)
        datestr += "0" + Day;
    else
        datestr += Day;

    datestr += "/";
    datestr += Year;

    return datestr;
}

function ConvertGregorianDate_Leap(Year, Month, Day)
{
    var datestr = "";
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
            if((Day >= 1) && (Day <= 11) && (PersianLeapYear(Year)))
            {
                Day += 20;
                Month += 2;
                Year += 621;
            }
            else if((Day >= 11) && (Day <= 30) && (!PersianLeapYear(Year)))
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
        datestr += "0" + Month;
    else
        datestr += Month;

    datestr += "/";
    if(Day < 10)
        datestr += "0" + Day;
    else
        datestr += Day;

    datestr += "/";
    datestr += Year;

    return datestr;
}


function Now()
{
    var calendar = new Date();
    this.date = toPersian(calendar.getFullYear(), calendar.getMonth()+1, calendar.getDate());
}

Now.prototype.Today = function()
{
    return this.date;
}

Now.prototype.Year = function()
{
    var year = [];
    year = SplitDate(this.date);
    return Number(year[0]);
}

Now.prototype.Month = function()
{
    var month = [];
    month = SplitDate(this.date);
    return Number(month[1]);
}

Now.prototype.Day = function()
{
    var day = [];
    day = SplitDate(this.date);
    return Number(day[2]);
}


function getYearOf(Year, Month, Day)
{
    var date = toPersian(Year, Month, Day);
    var year = [];
    year = SplitDate(date);
    return Number(year[0]);
}

function getMonthOf(Year, Month, Day)
{
    var date = toPersian(Year, Month, Day);
    var month = [];
    month = SplitDate(date);
    return Number(month[1]);
}

function getDayOf(Year, Month, Day)
{
    var date = toPersian(Year, Month, Day);
    var day = [];
    day = SplitDate(date);
    return Number(day[2]);
}


function Extract(FullDate){
    this.date = [];
    this.date = SplitDate(FullDate);
}

Extract.prototype.Year = function()
{
    return Number(this.date[0]);
}

Extract.prototype.Month = function()
{
    return Number(this.date[1]);
}

Extract.prototype.Day = function()
{
    return Number(this.date[2]);
}


function getMaxDay(year, month)
{
    var maxday = 0;

    if(month>=1 && month<=6)
        maxday = 31;
    else if(month>=7 && month<=11)
        maxday = 30;
    else
        maxday = (PersianLeapYear(year)) ? 30 : 29;

    return maxday;
}


function getDayOfWeek(fullDate)
{
    var calendar = new Date();
    var date = [];
    date = SplitDate(toGregorian(fullDate));
    calendar.setFullYear(Number(date[0]), Number(date[1]), Number(date[2]));
    var weekday = calendar.getDay();
    if(weekday==7)
        return 0;
    else
        return weekday;
}

function GregorianLeapYear(Year)
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

function PersianLeapYear(Year)
{
    var tens = Year % 100;
    var ones = Year % 10;
    tens -= ones;
    tens /= 10;
    if ((tens == 1 || tens % 2 == 1) && (ones == 1 || ones % 4 == 1))
        return true;
    else
        return ((tens == 0 || tens % 2 == 0) && (ones == 3 || ones == 7));
}

function SplitDate(FullDate){
    var date = [];
    date = FullDate.split("/");
    if(date.length<2)
        date = FullDate.split("-");
    return date;
}
