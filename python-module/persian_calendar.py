#!/usr/bin/env python3
from datetime import datetime
from convert import to_persian
from utilities import split_date

__author__ = "S. Vahid Hosseini"
__license__ = "GPL-3.0"
__version__ = "0.1"
__maintainer__ = "S. Vahid Hosseini"
__email__ = "s.vahid.h@behmerd.ir"
__status__ = "Dev"

def yoday():

    calendar = datetime.today()
    return  to_persian(calendar.year, calendar.month , calendar.day)


def year():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month , calendar.day)
    year = split_date(date)
    return int(year[0])


def month():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month , calendar.day)
    month = split_date(date)
    return int(month[1])


def day():

    calendar = datetime.today()
    date = to_persian(calendar.year, calendar.month , calendar.day)
    day = split_date(date)
    return int(day[2])

# TODO: remove followings before final release
def main():
    pass


if __name__ == '__main__':
    main()
