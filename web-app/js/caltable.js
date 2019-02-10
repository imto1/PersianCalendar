/*

██╗███╗   ███╗████████╗ ██████╗  ██╗
██║████╗ ████║╚══██╔══╝██╔═══██╗███║
██║██╔████╔██║   ██║   ██║   ██║╚██║
██║██║╚██╔╝██║   ██║   ██║   ██║ ██║
██║██║ ╚═╝ ██║   ██║   ╚██████╔╝ ██║
╚═╝╚═╝     ╚═╝   ╚═╝    ╚═════╝  ╚═╝

*/


function nextYear(year, month, day) {
	var packed = "";
	packed = new String(++year);
	packed += "&";
	packed += new String(month);
	packed += "&";
	packed += new String(day);
	window.location = '?' + packed;
}

function prevYear(year, month, day) {
	var packed = "";
	packed = new String(--year);
	packed += "&";
	packed += new String(month);
	packed += "&";
	packed += new String(day);
	window.location = '?' + packed;
}

function nextMonth(year, month, day) {
	var packed = "";
	if((month + 1) <= 11) {
		packed = new String(year);
		packed += "&";
		packed += new String(++month);
	}
	else {
		packed = new String(++year);
		packed += "&";
		packed += "0";
	}
	packed += "&";
	packed += new String(day);
	window.location = '?' + packed;
}

function prevMonth(year, month, day) {
	var packed = "";
	packed = new String(year);
	packed += "&";
	if((month -1 ) >= 0) {
		packed = new String(year);
		packed += "&";
		packed += new String(--month);
	}
	else {
		packed = new String(--year);
		packed += "&";
		packed += "11";
	}
	packed += "&";
	packed += new String(day);
	window.location = '?' + packed;
}

function fillTable(yy ,mm, dd)
{
	var dayofweek = 0;
	var d = parseInt(new Date(yy, mm, dd).getDay());
    let dateAt = new getDateAt(yy, mm+1, dd);
	var day = parseInt(dateAt.Day());
	var month = parseInt(dateAt.Month());
	var year = parseInt(dateAt.Year());
	var week = 1;
	var maxday = getMaxDay(year, month);
	var monthstr = "";
    let now = new Now();
	
		switch(month)
		{
			case 1:
				monthstr="فروردين";
				break;
			case 2:
				monthstr="ارديبهشت";
				break;
			case 3:
				monthstr="خرداد";
				break;
			case 4:
				monthstr="تير";
				break;
			case 5:
				monthstr="امرداد";
				break;
			case 6:
				monthstr="شهريور";
				break;
			case 7:
				monthstr="مهر";
				break;
			case 8:
				maxday=30;
				monthstr="آبان";
				break;
			case 9:
				monthstr="آذر";
				break;
			case 10:
				monthstr="دي";
				break;
			case 11:
				monthstr="بهمن";
				break;
			case 12:
				monthstr="اسپند";
				break;
		}

		document.getElementById("headyear").innerHTML = new String(year);
		document.getElementById("headmonth").innerHTML = monthstr;
		if(day > 1)
		{
			var i;
			for(i = day;i >= 1;i--)
				if(--day >= 1)
					if(d <= 0)
						d = 6;
					else
						--d;
		}
		else if(day == 1)
			--day;

		for(week = 1;week <= 5;week++)
		{
			if(day < 1 && d == 6)
			{
				document.getElementById(new String(week) + new String(d)).innerHTML = ++day;
				if(day == parseInt(now.Day()))
					document.getElementById(new String(week) + new String(d)).className += "td";
				d = 0;
			}
			for(dayofweek = d;dayofweek <= 5;dayofweek++)
				if(day < maxday)
				{
					document.getElementById(new String(week) + new String(dayofweek)).innerHTML = ++day;
					if(day == parseInt(now.Day()))
						document.getElementById(new String(week) + new String(dayofweek)).className += "td";
				}
				else
					break;
			d = dayofweek;
			if(day < maxday && day >= 1 && week < 5)
			{
				document.getElementById(new String(week+1) + new String(dayofweek)).innerHTML = ++day;
				if(day == parseInt(now.Day()))
					document.getElementById(new String(week + 1) + new String(dayofweek)).className += "td";
				d = 0;
			}
		}
		if(day < maxday)
		{
			if(day < maxday && day >= 1)
			{
				document.getElementById(new String(1) + new String(dayofweek)).innerHTML = ++day;
				if(day == parseInt(now.Day()))
					document.getElementById(new String(1) + new String(dayofweek)).className += "td";
				d = 0;
			}
			for(dayofweek = d;dayofweek <= 5;dayofweek++)
				if(day < maxday)
				{
					document.getElementById(new String(1) + new String(dayofweek)).innerHTML = ++day;
					if(day == parseInt(now.Day()))
						document.getElementById(new String(1) + new String(dayofweek)).className += "td";
				}
				else
					break;
		}
}