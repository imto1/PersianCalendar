#!/usr/bin/env python3
import datetime

__author__ = "S. Vahid Hosseini"
__license__ = "GPL-3.0"
__version__ = "0.1"
__maintainer__ = "S. Vahid Hosseini"
__email__ = "s.vahid.h@behmerd.ir"
__status__ = "Dev"

class convert:
	'''Conversion class of gregorian & persian date'''

	# TODO: Remove redundant blocks

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
	    

# TODO: remove followings before final release
def main():
	pass

if __name__ == '__main__':
    main()