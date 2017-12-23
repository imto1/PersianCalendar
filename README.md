# Persian Calendar library for Java
This is a class library for use in Java/Android projects.

<b>Usage:</b><br />
<pre>PersianCalendar pc = new PersianCalendar();</pre><br />

<b>Methods:</b><br />
<a href="#ctp"><code>convertToPersian()</code></a><br />
<a href="#ctg"><code>convertToGregorian()</code></a><br />
<a href="#gn"><code>getNow()</code></a><br />
<a href="#gy"><code>getYear()</code></a><br />
<a href="#gm"><code>getMonth()</code></a><br />
<a href="#gd"><code>getDay()</code></a><br />
<a href="#gyo"><code>getYearOf()</code></a><br />
<a href="#gmo"><code>getMonthOf()</code></a><br />
<a href="#gdo"><code>getDayOf()</code></a><br />
<a href="#gmd"><code>getMaxDay()</code></a><br />
<a href="#gdow"><code>getDayOfWeek()</code></a><br /><br /><br />

<a id="ctp"></a><code>convertToPersian()</code> Converting gregorian date to persian date.<br /><br />
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

String date = pc.convertToPersian(1987, 1, 19);
String date = pc.convertToPersian("1-19-1987");        
</pre>
<br /><br /><br />
<a id="ctg"></a><code>convertToGregorian()</code> Converting persian date to gregorian date.<br /><br />
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

String date = pc.convertToGregorian(1365, 10, 29);
String date = pc.convertToGregorian("1365/10/29");        
</pre>
<br /><br /><br />
<a id="gn"></a><code>getNow()</code> Current system date in persian.<br /><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

String date = pc.getNow();       
</pre>
<br /><br /><br />
<a id="gy"></a><code>getYear()</code>Return the Year of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int year = pc.getYear();       
</pre>
<br /><br /><br />
<a id="gm"></a><code>getMonth()</code>Return the Month of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int month = pc.getMonth();       
</pre>
<br /><br /><br />
<a id="gd"></a><code>getDay()</code>Return the Day of current system date in persian.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int day = pc.getDay();       
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

int year = pc.getYearOf(int Year, int Month, int Day);       
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

int month = pc.getMonthOf(int Year, int Month, int Day);       
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

int day = pc.getDayOf(int Year, int Month, int Day);       
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

int maxDay = pc.getMaxDay(int Year, int Month);       
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

int weekDay = pc.getDayOfWeek("1365-10-29");       
</pre>
