from utilities import split_date

class convert:
    '''Conversion class of gregorian & persian date.'''

    # TODO: Remove redundant blocks
    def toPersian(self, *args):
        '''You should give me integer \'year, month, day\' or string like \'2-27-2020\'.'''
        date = []
        for arg in enumerate(args):
            date.append(arg)
        
        if len(date) == 1:
            date = split_date(str(date[0]))
        elif len(date) > 1:
            pass
        else:
            print('Bad arguments...!')

        if Utilities.GregorianLeapyear(year):
            return ConvertPersianDate_Leap(year, month, day)
        else:
            return ConvertPersianDate_NotLeap(year, month, day, Utilities.GregorianLeapyear(year - 1))
            

    def toGregorian(self, *args):

        leap = False
        if month >= 1 and month <= 9:
            leap = Utilities.GregorianLeapyear(year + 621)
        elif month == 10:

            if Utilities.PersianLeapyear(year):

                if day >= 1 and day <= 11:
                    leap = Utilities.GregorianLeapyear(year + 621)
            else:
                if day >= 1 and day <= 10:
                    leap = Utilities.GregorianLeapyear(year + 621)
        else:
            leap = Utilities.GregorianLeapyear(year + 622)

        if leap:
            return ConvertGregorianDate_Leap(year, month, day)
        else:
            return ConvertGregorianDate_NotLeap(year, month, day, Utilities.PersianLeapyear(year))

        date = Utilities.SplitDate(FullDate)
        return toGregorian(int(date[0]), int(date[1]), int(date[2]))

    def convert_persian_date(self, year, month, day, after_leap):
        '''Convert gregorian date to persian date.'''

        datestr = ''

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

        elif month == 7:
            if day >= 1 and day <= 22:
                day += 9
                month -= 3
            elif day >= 23 and day <= 31:
                day -= 22
                month -= 2
            year -= 621

        elif month == 8:
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

        datestr = str(year)
        datestr += '/'
        if month < 10:
            datestr += '0' + str(month)
        else:
            datestr += str(month)
        datestr += '/'
        if day < 10:
            datestr += '0' + str(day)
        else:
            datestr += str(day)

        return datestr

    def convert_persian_leap_date(self, year, month, day):
        '''Convert gregorian date to persian date in leap year.'''

        datestr = ''

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

        elif month == 7:
            if day >= 1 and day <= 21:
                day += 10
                month -= 3
            elif day >= 22 and day <= 31:
                day -= 21
                month -= 2
            year -= 621

        elif month == 8:
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

        datestr = str(year)
        datestr += '/'
        if month < 10:
            datestr += '0' + str(month)
        else:
            datestr += str(month)
        datestr += '/'
        if day < 10:
            datestr += '0' + str(day)
        else:
            datestr += str(day)

        return datestr

    def convert_gregorian_date(self, year, month, day, leap):
        '''Convert persian date to greforian date.'''

        datestr = ''

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

        elif month == 5:
            if day >= 1 and day <= 9:
                day += 22
                month += 2
            elif day >= 10 and day <= 31:
                day -= 9
                month += 3
            year += 621

        elif month == 6:
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

        if month < 10:
            datestr = '0' + str(month)
        else:
            datestr = str(month)
        datestr += '/'
        if day < 10:
            datestr += '0' + str(day)
        else:
            datestr += str(day)
        datestr += '/'
        datestr += str(year)

        return datestr

    def convert_gregorian_leap_date(self, year, month, day):
        '''Convert persian date to greforian date in leap year.'''

        datestr = ''

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

        elif month == 5:
            if day >= 1 and day <= 10:
                day += 21
                month += 2
            elif day >= 11 and day <= 31:
                day -= 10
                month += 3
            year += 621

        elif month == 6:
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
        # TODO: fix utility calls after migration compeleted
        elif month == 10:
            if day >= 1 and day <= 11 and Utilities.PersianLeapyear(year):
                day += 20
                month += 2
                year += 621
            elif day >= 11 and day <= 30 and not Utilities.PersianLeapyear(year):
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

        if month < 10:
            datestr = '0' + str(month)
        else:
            datestr = str(month)
        datestr += '/'
        if day < 10:
            datestr += '0' + str(day)
        else:
            datestr += str(day)
        datestr += '/'
        datestr += str(year)

        return datestr