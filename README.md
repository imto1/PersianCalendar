# Persian Calendar library for Java
This is a class library for use in Java/Android projects.

<b>Usage:</b><br />
<pre>PersianCalendar pc = new PersianCalendar();</pre><br />


<b>Subclasses:</b><br />
<ul>
  <li>Convert</li>
  <li>Now</li>
  <li>Utility</li>
</ul>

<h2>Methods:</h2><br />
<strong>Convert</strong><br />
<a href="#ctp"><code>toPersian()</code></a><br />
<a href="#ctg"><code>toGregorian()</code></a><br /><br />

<strong>Now</strong><br />
<a href="#gn"><code>Today()</code></a><br />
<a href="#gy"><code>Year()</code></a><br />
<a href="#gm"><code>Month()</code></a><br />
<a href="#gd"><code>Day()</code></a><br /><br />

<strong>Utility</strong><br />
<a href="#gyo"><code>getYearOf()</code></a><br />
<a href="#gmo"><code>getMonthOf()</code></a><br />
<a href="#gdo"><code>getDayOf()</code></a><br />
<a href="#ey"><code>extractYear()</code></a><br />
<a href="#em"><code>extractMonth()</code></a><br />
<a href="#ed"><code>extractDay()</code></a><br />
<a href="#gmd"><code>getMaxDay()</code></a><br />
<a href="#gdow"><code>getDayOfWeek()</code></a><br />
<a href="#gly"><code>GregorianLeapYear()</code></a><br />
<a href="#ply"><code>PersianLeapYear()</code></a><br /><br /><br />

<a id="ctp"></a><code>toPersian()</code> Converting gregorian date to persian date.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day</i><br />
or String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"MM-DD-YYYY"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"MM/DD/YYYY"<br /></i><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

String date = pc.Convert.toPersian(1987, 1, 19);
String date = pc.Convert.toPersian("1-19-1987");        
</pre>
<br /><br /><br />
<a id="ctg"></a><code>toGregorian()</code> Converting persian date to gregorian date.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day</i><br />
or String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

String date = pc.Convert.toGregorian(1365, 10, 29);
String date = pc.Convert.toGregorian("1365/10/29");        
</pre>
<br /><br /><br />
<a id="gn"></a><code>Today()</code> Current system date in persian.<br /><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

String date = pc.Now.Today();       
</pre>
<br /><br /><br />
<a id="gy"></a><code>Year()</code>Return the Year of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int year = pc.Now.Year();       
</pre>
<br /><br /><br />
<a id="gm"></a><code>Month()</code>Return the Month of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int month = pc.Now.Month();       
</pre>
<br /><br /><br />
<a id="gd"></a><code>Day()</code>Return the Day of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int day = pc.Now.Day();       
</pre>
<br /><br /><br />
<a id="gyo"></a><code>getYearOf()</code>Return the Year of specified date in persian.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int year = pc.Utility.getYearOf(int Year, int Month, int Day);       
</pre>
<br /><br /><br />
<a id="gmo"></a><code>getMonthOf()</code>Return the Month of specified date in persian.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int month = pc.Utility.getMonthOf(int Year, int Month, int Day);       
</pre>
<br /><br /><br />
<a id="gdo"></a><code>getDayOf()</code>Return the Day of specified date in persian.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int day = pc.Utility.getDayOf(int Year, int Month, int Day);       
</pre>
<br /><br /><br />
<a id="ey"></a><code>extractYear()</code>Extracts the Year of given date for string parameters.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int year = pc.Utility.extractYear("1365/10/29");       
</pre>
<br /><br /><br />
<a id="em"></a><code>extractMonth()</code>Extracts the Month of given date for string parameters.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int month = pc.Utility.extractMonth("1365/10/29");       
</pre>
<br /><br /><br />
<a id="ed"></a><code>extractDay()</code>Extracts the Day of given date for string parameters.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int day = pc.Utility.extractDay("1365/10/29");       
</pre>
<br /><br /><br />
<a id="gmd"></a><code>getMaxDay()</code>Number of days in specified Month.<br /><br />
Arguments:<br />
Integer values for Year and Month<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int maxDay = pc.Utility.getMaxDay(int Year, int Month);       
</pre>
<br /><br /><br />
<a id="gdow"></a><code>getDayOfWeek()</code>Return the Day of week for specified date in persian.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int weekDay = pc.Utility.getDayOfWeek("1365-10-29");       
</pre>
<br /><br /><br />
<a id="gly"></a><code>GregorianLeapYear()</code>Return the leap year status for gregorian year.<br /><br />
Arguments:<br />
Integer values for Year<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year<br />
Return value: <i>Boolean</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

boolean leap = pc.Utility.GregorianLeapYear(2017);       
</pre>
<br /><br /><br />
<a id="ply"></a><code>PersianLeapYear()</code>Return the leap year status for persian year.<br /><br />
Arguments:<br />
Integer values for Year<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year<br />
Return value: <i>Boolean</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

boolean leap = pc.Utility.PersianLeapYear(1396);       
</pre>
