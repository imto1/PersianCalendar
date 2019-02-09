﻿/*

██╗███╗   ███╗████████╗ ██████╗  ██╗
██║████╗ ████║╚══██╔══╝██╔═══██╗███║
██║██╔████╔██║   ██║   ██║   ██║╚██║
██║██║╚██╔╝██║   ██║   ██║   ██║ ██║
██║██║ ╚═╝ ██║   ██║   ╚██████╔╝ ██║
╚═╝╚═╝     ╚═╝   ╚═╝    ╚═════╝  ╚═╝

*/

//---------------------------------------------------------------------------------------------------------------------------

function ToPersianByInt(Year, Month, Day)
{
	return CPDate(Year, Month, Day);
}

//---------------------------------------------------------------------------------------------------------------------------

function ToPersianByStr(FullDate)
{
	var y, m, d, l;
	var c;
	l = FullDate.length;
	if (FullDate.substring(1, 2) == "/" || FullDate.substring(1, 2) == "-" || FullDate.substring(2, 3) == "/" || FullDate.substring(2, 3) == "-")
	{
		y = FullDate.substring((FullDate.length-4), FullDate.length);
		if (l == 10)
		{
			d = FullDate.substring(3, 5);
			m = FullDate.substring(0, 2);
		}
		else if (l == 9)
		{
			c = FullDate.substring(1, 2);
			if (c == "/" || c == "-")
			{
				d = FullDate.substring(2, 4);
				m = FullDate.substring(0, 1);
			}
			else
			{
				d = FullDate.substring(3, 4);
				m = FullDate.substring(0, 2);
			}
		}
		else if (l == 8)
		{
			d = FullDate.substring(2, 3);
			m = FullDate.substring(0, 1);
		}
	}
	else
	{
		y = FullDate.substring(0, 4);
		if (l == 10)
		{
			m = FullDate.substring(5, 7);
			d = FullDate.substring((FullDate.length-2), FullDate.length);
		}
		else if (l == 9)
		{
			c = FullDate.substring(6, 7);
			if (c == "/" || c == "-")
			{
				m = FullDate.substring(5, 6);
				d = FullDate.substring((FullDate.length-2), FullDate.length);
			}
			else
			{
				m = FullDate.substring(5, 7);
				d = FullDate.substring((FullDate.length-1), FullDate.length);
			}
		}
		else if (l == 8)
		{
			m = FullDate.substring(5, 6);
			d = FullDate.substring((FullDate.length-1), FullDate.length);
		}
	}
	return CPDate(parseInt(y), parseInt(m), parseInt(d));
}

//---------------------------------------------------------------------------------------------------------------------------

function ToGregorianByInt(Year, Month, Day)
{
	return CGDate(Year, Month, Day);
}

//---------------------------------------------------------------------------------------------------------------------------

function ToGregorianByStr(FullDate)
{
	var y, m, d, l;
	var c;
	l = FullDate.length;
	y = FullDate.substring(0, 4);
	if (l == 10)
	{
		m = FullDate.substring(5, 7);
		d = FullDate.substring((FullDate.length-2), FullDate.length);
	}
	else if (l == 9)
	{
		c = FullDate.substring(6, 7);
		if (c == "/" || c == "-")
		{
			m = FullDate.substring(5, 6);
			d = FullDate.substring((FullDate.length-2), FullDate.length);
		}
		else
		{
			m = FullDate.substring(5, 7);
			d = FullDate.substring((FullDate.length-1), FullDate.length);
		}
	}
	else if (l == 8)
	{
		m = FullDate.substring(5, 6);
		d = FullDate.substring((FullDate.length-1), FullDate.length);
	}
	return CGDate(parseInt(y), parseInt(m), parseInt(d))
}

//---------------------------------------------------------------------------------------------------------------------------

function Now()
{
	var dat = new Date();
	return  ToPersianByInt(dat.getFullYear(), dat.getMonth()+1, dat.getDate());
}

//---------------------------------------------------------------------------------------------------------------------------

function Year()
{
	var str;
	var dat = new Date();
	str = ToPersianByInt(dat.getFullYear(), dat.getMonth()+1, dat.getDate());
	str = str.substring(0, 4);
	return str;
}

//---------------------------------------------------------------------------------------------------------------------------

function Month()
{
	var str;
	var dat = new Date();
	str = ToPersianByInt(dat.getFullYear(), dat.getMonth()+1, dat.getDate());
	str = str.substring(5, 7);
	return str;
}

//---------------------------------------------------------------------------------------------------------------------------

function Day()
{
	var str;
	var dat = new Date();
	str = ToPersianByInt(dat.getFullYear(), dat.getMonth()+1, dat.getDate());
	str = str.substring((str.length-2), str.length);
	return str;
}
//---------------------------------------------------------------------------------------------------------------------------

function cYear(Year, Month, Day)
{
	var str;
	str = ToPersianByInt(Year, Month, Day);
	str = str.substring(0, 4);
	return str;
}

//---------------------------------------------------------------------------------------------------------------------------

function cMonth(Year, Month, Day)
{
	var str;
	str = ToPersianByInt(Year, Month, Day);
	str = str.substring(5, 7);
	return str;
}

//---------------------------------------------------------------------------------------------------------------------------

function cDay(Year, Month, Day)
{
	var str;
	str = ToPersianByInt(Year, Month, Day);
	str = str.substring((str.length-2), str.length);
	return str;
}

//---------------------------------------------------------------------------------------------------------------------------
//Convert Date

function IsLeapYearG(Year)
{
	Year = parseInt(Year);
	if(Year%4 == 0) 
	{ 
		if(Year%100 != 0)
		{
			return true;
		}
		else
		{
			if(Year%400 == 0)
				return true; 
			else 
				return false;
		}
	}
	return false;
}
//---------------------------------------------------------------------------------------------------------------------------

function IsLeapYearP(Year)
{
	var d, y;
	d = Year % 100;
	y = Year % 10;
	d -= y;
	d /= 10;
	if ((d == 1 || d == 3 || d == 5 || d == 7 || d == 9) && (y == 1 || y == 5 || y == 9))
		return true;
	else if ((d == 0 || d == 2 || d == 4 || d == 6 || d == 8) && (y == 3 || y == 7))
		return true;
	else
		return false;
}

//---------------------------------------------------------------------------------------------------------------------------

function isInteger(s)
{ 
	var i;s = s.toString();
	for (i = 0; i < s.length; i++)
	{ 
		var c = s.charAt(i);
		if (isNaN(c))
		{
			alert("Given value is not a number");
			return false;
		}
	}
	 return true;
}

//---------------------------------------------------------------------------------------------------------------------------

function CPDate(Year, Month, Day)
{
	if (IsLeapYearG(Year))
		return cplyd(Year, Month, Day);
	else
		return cpnlyd(Year, Month, Day, IsLeapYearG(Year - 1));
}

//---------------------------------------------------------------------------------------------------------------------------

function CGDate(Year, Month, Day)
{
	var L = false;
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

//---------------------------------------------------------------------------------------------------------------------------

function cpnlyd(Year, Month, Day, AL)
{
	var datestr="";
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

	datestr = Year;
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

//---------------------------------------------------------------------------------------------------------------------------

function cplyd(Year, Month, Day)
{
	var datestr="";
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


	datestr = Year;
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

//---------------------------------------------------------------------------------------------------------------------------

function cgnlyd(Year, Month, Day, L)
{
	var datestr="";
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
		datestr = "0" + Month;
	else
		datestr = Month;

	datestr = datestr + "/";
	if(Day < 10)
		datestr = datestr + "0" + Day;
	else
		datestr = datestr + Day;

	datestr = datestr + "/";
	datestr = datestr + Year;

	return datestr;
}

//---------------------------------------------------------------------------------------------------------------------------

function cglyd(Year, Month, Day)
{
	var datestr="";
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
		datestr = "0" + Month;
	else
		datestr = Month;

	datestr = datestr + "/";
	if(Day < 10)
		datestr = datestr + "0" + Day;
	else
		datestr = datestr + Day;

	datestr = datestr + "/";
	datestr = datestr + Year;

	return datestr;
}