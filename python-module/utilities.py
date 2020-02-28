'''Utility module of persian calendar.'''
from datetime import datetime

from convert import to_gregorian, to_persian


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
