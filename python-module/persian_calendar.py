#!/usr/bin/env python3
from datetime import datetime

__author__ = "S. Vahid Hosseini"
__license__ = "GPL-3.0"
__version__ = "0.1"
__maintainer__ = "S. Vahid Hosseini"
__email__ = "s.vahid.h@behmerd.ir"
__status__ = "Dev"

# TODO: add doc string for all functions


# now
def today():

    calendar = datetime.today()
    return to_persian(calendar.year, calendar.month, calendar.day)


def year():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month, calendar.day)
    year = split_date(date)
    return int(year[0])


def month():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month, calendar.day)
    month = split_date(date)
    return int(month[1])


def day():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month, calendar.day)
    day = split_date(date)
    return int(day[2])


# utility
def split_date(datestr):
    date = datestr.split("/")
    if len(date) < 2:
        date = datestr.split("-")
    return date


def gregorian_leap_year(year):
    if year % 4 == 0:
        if year % 100 != 0:
            return True
        else:
            return (year % 400 == 0)
    return False


def persian_leap_year(year):
    tens = year % 100
    ones = year % 10
    tens -= ones
    tens /= 10
    if (tens == 1 or tens % 2 == 1) and (ones == 1 or ones % 4 == 1):
        return True
    else:
        return ((tens == 0 or tens % 2 == 0) and (ones == 3 or ones == 7))


def get_year_of(Year, Month, Day):

    date = to_persian(Year, Month, Day)
    year = split_date(date)
    return int(year[0])


def get_month_of(Year,  Month,  Day):

    date = to_persian(Year, Month, Day)
    month = split_date(date)
    return int(month[1])


def get_day_of(Year,  Month,  Day):

    date = to_persian(Year, Month, Day)
    day = split_date(date)
    return int(day[2])


def extract_year(FullDate):

    year = split_date(FullDate)
    return int(year[0])


def extract_month(FullDate):

    month = split_date(FullDate)
    return int(month[1])


def extract_day(FullDate):

    day = split_date(FullDate)
    return int(day[2])


def gwt_max_day(year,  month):

    if month >= 1 and month <= 6:
        return 31
    elif month >= 7 and month <= 11:
        return 30
    else:
        if persian_leap_year(year):
            return 30
        else:
            return 29


def get_day_of_week(fullDate):

    date = datetime.fromisoformat(to_gregorian(fullDate))
    weekday = date.weekday()
    if weekday >= 0 and weekday <= 4:
        return weekday + 2
    else:
        return weekday - 5


def format_date(year, month, day):
    datestr = str(year)
    datestr += '-'
    if month < 10:
        datestr += '0' + str(month)
    else:
        datestr += str(month)
    datestr += '-'
    if day < 10:
        datestr += '0' + str(day)
    else:
        datestr += str(day)

    return datestr


# conversion
def to_persian(*args):
    '''You should give me integer (year, month, day) or string like \'2-27-2020\' or \'2020/2/27\'.'''

    date = []
    for arg in args:
        date.append(arg)

    if len(date) == 1:
        date = split_date(str(date[0]))
    elif len(date) < 1 or len(date) == 2 or len(date) > 3:
        print('Bad arguments...!')
        return None

    year, month, day = date
    year = int(year)
    month = int(month)
    day = int(day)

    if gregorian_leap_year(year):
        return convert_persian_leap_date(year, month, day)
    else:
        return convert_persian_date(year, month, day, gregorian_leap_year(year - 1))


def to_gregorian(*args):
    '''You should give me integer (year, month, day) or string like \'1398-12-9\' or \'1398/12/9\'.'''

    date = []
    for arg in enumerate(args):
        date.append(arg)

    if len(date) == 1:
        date = split_date(str(date[0]))
    elif len(date) < 1 or len(date) == 2 or len(date) > 3:
        print('Bad arguments...!')
        return None

    year, month, day = date
    year = int(year)
    month = int(month)
    day = int(day)

    leap = False
    if month >= 1 and month <= 9:
        leap = gregorian_leap_year(year + 621)
    elif month == 10:
        if persian_leap_year(year):
            if day >= 1 and day <= 11:
                leap = gregorian_leap_year(year + 621)
        else:
            if day >= 1 and day <= 10:
                leap = gregorian_leap_year(year + 621)
    else:
        leap = gregorian_leap_year(year + 622)

    if leap:
        return convert_gregorian_leap_date(year, month, day)
    else:
        return convert_gregorian_date(year, month, day, persian_leap_year(year))


def convert_persian_date(year, month, day, after_leap):
    '''Convert gregorian date to persian date.'''

    if month == 1:
        if after_leap:
            if day >= 1 and day <= 19:
                day += 11
                month += 9
            elif day >= 20 and day <= 31:
                day -= 19
                month += 10
        else:
            if day >= 1 and day <= 20:
                day += 10
                month += 9
            elif day >= 21 and day <= 31:
                day -= 20
                month += 10
        year -= 622

    elif month == 2:
        if after_leap:
            if day >= 1 and day <= 18:
                day += 12
                month += 9
            elif day >= 19 and day <= 28:
                day -= 18
                month += 10
        else:
            if day >= 1 and day <= 19:
                day += 11
                month += 9
            elif day >= 20 and day <= 28:
                day -= 19
                month += 10
        year -= 622

    elif month == 3:
        if day >= 1 and day <= 20:
            if after_leap:
                day += 10
                month += 9
            else:
                day += 9
                month += 9
                year -= 622
        elif day >= 21 and day <= 31:
            day -= 20
            month -= 2
            year -= 621
    elif month == 4:
        if day >= 1 and day <= 20:
            day += 11
            month -= 3
        elif day >= 21 and day <= 30:
            day -= 20
            month -= 2
        year -= 621

    elif month == 5:
        if day >= 1 and day <= 21:
            day += 10
            month -= 3
        elif day >= 22 and day <= 31:
            day -= 21
            month -= 2
        year -= 621

    elif month == 6:
        if day >= 1 and day <= 21:
            day += 10
            month -= 3
        elif day >= 22 and day <= 30:
            day -= 21
            month -= 2
        year -= 621

    elif month == 7 or month == 8:
        if day >= 1 and day <= 22:
            day += 9
            month -= 3
        elif day >= 23 and day <= 31:
            day -= 22
            month -= 2
        year -= 621

    elif month == 9:
        if day >= 1 and day <= 22:
            day += 9
            month -= 3
        elif day >= 23 and day <= 30:
            day -= 22
            month -= 2
        year -= 621

    elif month == 10:
        if day >= 1 and day <= 22:
            day += 8
            month -= 3
        elif day >= 23 and day <= 31:
            day -= 22
            month -= 2
        year -= 621

    elif month == 11:
        if day >= 1 and day <= 21:
            day += 9
            month -= 3
        elif day >= 22 and day <= 30:
            day -= 21
            month -= 2
        year -= 621

    elif month == 12:
        if day >= 1 and day <= 21:
            day += 9
            month -= 3
        elif day >= 22 and day <= 31:
            day -= 21
            month -= 2
        year -= 621

    return format_date(year, month, day)


def convert_persian_leap_date(year, month, day):
    '''Convert gregorian date to persian date in leap year.'''

    if month == 1:
        if day >= 1 and day <= 20:
            day += 10
            month += 9
        elif day >= 21 and day <= 31:
            day -= 20
            month += 10
        year -= 622

    elif month == 2:
        if day >= 1 and day <= 19:
            day += 11
            month += 9
        elif day >= 20 and day <= 29:
            day -= 19
            month += 10
        year -= 622

    elif month == 3:
        if day >= 1 and day <= 19:
            day += 10
            month += 9
            year -= 622
        elif day >= 20 and day <= 31:
            day -= 19
            month -= 2
            year -= 621

    elif month == 4:
        if day >= 1 and day <= 19:
            day += 12
            month -= 3
        elif day >= 20 and day <= 30:
            day -= 19
            month -= 2
        year -= 621

    elif month == 5:
        if day >= 1 and day <= 20:
            day += 11
            month -= 3
        elif day >= 21 and day <= 31:
            day -= 20
            month -= 2
        year -= 621

    elif month == 6:
        if day >= 1 and day <= 20:
            day += 11
            month -= 3
        elif day >= 21 and day <= 30:
            day -= 20
            month -= 2
        year -= 621

    elif month == 7 or month == 8:
        if day >= 1 and day <= 21:
            day += 10
            month -= 3
        elif day >= 22 and day <= 31:
            day -= 21
            month -= 2
        year -= 621

    elif month == 9:
        if day >= 1 and day <= 21:
            day += 10
            month -= 3
        elif day >= 22 and day <= 30:
            day -= 21
            month -= 2
        year -= 621

    elif month == 10:
        if day >= 1 and day <= 21:
            day += 9
            month -= 3
        elif day >= 22 and day <= 31:
            day -= 21
            month -= 2
        year -= 621

    elif month == 11:
        if day >= 1 and day <= 20:
            day += 10
            month -= 3
        elif day >= 21 and day <= 30:
            day -= 20
            month -= 2
        year -= 621

    elif month == 12:
        if day >= 1 and day <= 20:
            day += 10
            month -= 3
        elif day >= 21 and day <= 31:
            day -= 20
            month -= 2
        year -= 621

    return format_date(year, month, day)


def convert_gregorian_date(year, month, day, leap):
    '''Convert persian date to greforian date.'''

    if month == 1:
        if day >= 1 and day <= 11:
            day += 20
            month += 2
        elif day >= 12 and day <= 31:
            day -= 11
            month += 3
        year += 621

    elif month == 2:
        if day >= 1 and day <= 10:
            day += 20
            month += 2
        elif day >= 11 and day <= 31:
            day -= 10
            month += 3
        year += 621

    elif month == 3:
        if day >= 1 and day <= 10:
            day += 21
            month += 2
        elif day >= 11 and day <= 31:
            day -= 10
            month += 3
        year += 621

    elif month == 4:
        if day >= 1 and day <= 9:
            day += 21
            month += 2
        elif day >= 10 and day <= 31:
            day -= 9
            month += 3
        year += 621

    elif month == 5 or month == 6:
        if day >= 1 and day <= 9:
            day += 22
            month += 2
        elif day >= 10 and day <= 31:
            day -= 9
            month += 3
        year += 621

    elif month == 7:
        if day >= 1 and day <= 8:
            day += 22
            month += 2
        elif day >= 9 and day <= 30:
            day -= 8
            month += 3
        year += 621

    elif month == 8:
        if day >= 1 and day <= 9:
            day += 22
            month += 2
        elif day >= 10 and day <= 30:
            day -= 9
            month += 3
        year += 621

    elif month == 9:
        if day >= 1 and day <= 9:
            day += 21
            month += 2
        elif day >= 10 and day <= 30:
            day -= 9
            month += 3
        year += 621

    elif month == 10:
        if leap:
            if day >= 12 and day <= 30:
                day -= 11
                month -= 9
                year += 622
        else:
            if day >= 1 and day <= 10:
                day += 21
                month += 2
                year += 621
            elif day >= 11 and day <= 30:
                day -= 10
                month -= 9
                year += 622

    elif month == 11:
        if leap:
            if day >= 1 and day <= 12:
                day += 19
                month -= 10
            elif day >= 13 and day <= 30:
                day -= 12
                month -= 9
        else:
            if day >= 1 and day <= 11:
                day += 20
                month -= 10
            elif day >= 12 and day <= 30:
                day -= 11
                month -= 9
        year += 622

    elif month == 12:
        if leap:
            if day >= 1 and day <= 10:
                day += 18
                month -= 10
            elif day >= 11 and day <= 30:
                day -= 10
                month -= 9
        else:
            if day >= 1 and day <= 9:
                day += 19
                month -= 10
            elif day >= 10 and day <= 29:
                day -= 9
                month -= 9
        year += 622

    return format_date(year, month, day)


def convert_gregorian_leap_date(year, month, day):
    '''Convert persian date to greforian date in leap year.'''

    if month == 1:
        if day >= 1 and day <= 12:
            day += 19
            month += 2
        elif day >= 13 and day <= 31:
            day -= 12
            month += 3
        year += 621

    elif month == 2:
        if day >= 1 and day <= 11:
            day += 19
            month += 2
        elif day >= 12 and day <= 31:
            day -= 11
            month += 3
        year += 621

    elif month == 3:
        if day >= 1 and day <= 11:
            day += 20
            month += 2
        elif day >= 12 and day <= 31:
            day -= 11
            month += 3
        year += 621

    elif month == 4:
        if day >= 1 and day <= 10:
            day += 20
            month += 2
        elif day >= 11 and day <= 31:
            day -= 10
            month += 3
        year += 621

    elif month == 5 or month == 6:
        if day >= 1 and day <= 10:
            day += 21
            month += 2
        elif day >= 11 and day <= 31:
            day -= 10
            month += 3
        year += 621

    elif month == 7:
        if day >= 1 and day <= 9:
            day += 21
            month += 2
        elif day >= 10 and day <= 30:
            day -= 9
            month += 3
        year += 621

    elif month == 8:
        if day >= 1 and day <= 10:
            day += 21
            month += 2
        elif day >= 11 and day <= 30:
            day -= 10
            month += 3
        year += 621

    elif month == 9:
        if day >= 1 and day <= 10:
            day += 20
            month += 2
        elif day >= 11 and day <= 30:
            day -= 10
            month += 3
        year += 621

    elif month == 10:
        if day >= 1 and day <= 11 and persian_leap_year(year):
            day += 20
            month += 2
            year += 621
        elif day >= 11 and day <= 30 and not persian_leap_year(year):
            day -= 10
            month -= 9
            year += 622

    elif month == 11:
        if day >= 1 and day <= 11:
            day += 20
            month -= 10
        elif day >= 12 and day <= 30:
            day -= 11
            month -= 9
        year += 622

    elif month == 12:
        if day >= 1 and day <= 10:
            day += 19
            month -= 10
        elif day >= 11 and day <= 29:
            day -= 10
            month -= 9
        year += 622

    return format_date(year, month, day)


# TODO: remove followings before final release


def main():
    print(today())


if __name__ == '__main__':
    main()
