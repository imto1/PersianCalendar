# Persian Calendar Project
This is my own algorithm of Persian Calendar. This project contains: 
<ol>
    <li>Java class library for use in Java/Android projects.</li>
    <li>Persian Calendar Android application.</li>
    <li>Javascript library and a simple web application.</li>
</ol><br />

<b>Usage:</b><br />
<ol>
    <li><a href="#jusage"><code>Java</code></a></li>
    <li><a href="#jsusage"><code>Javascript</code></a></li>
</ol>

<a id="jusage"></a><h1>Java</h1>
<pre>PersianCalendar pc = new PersianCalendar();</pre><br />


<b>Subclasses and their functions:</b><br />
<ul>
  <li><a href="#convert">Convert</a></li>
    <a id="convert"></a><strong>Convert</strong><br />
    <a href="#ctp"><code>toPersian()</code></a><br />
    <a href="#ctg"><code>toGregorian()</code></a><br /><br />
  <li><a href="#now">Now</a></li>
    <a id="now"></a><strong>Now</strong><br />
    <a href="#gn"><code>Today()</code></a><br />
    <a href="#gy"><code>Year()</code></a><br />
    <a href="#gm"><code>Month()</code></a><br />
    <a href="#gd"><code>Day()</code></a><br /><br />
  <li><a href="#utility">Utility</a></li>
    <a id="utility"></a><strong>Utility</strong><br />
    <a href="#gyo"><code>getYearOf()</code></a><br />
    <a href="#gmo"><code>getMonthOf()</code></a><br />
    <a href="#gdo"><code>getDayOf()</code></a><br />
    <a href="#ey"><code>extractYear()</code></a><br />
    <a href="#em"><code>extractMonth()</code></a><br />
    <a href="#ed"><code>extractDay()</code></a><br />
    <a href="#gmd"><code>getMaxDay()</code></a><br />
    <a href="#gdow"><code>getDayOfWeek()</code></a><br />
    <a href="#gly"><code>GregorianLeapYear()</code></a><br />
    <a href="#ply"><code>PersianLeapYear()</code></a>
</ul>
<br /><br /><br />

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
<a id="gy"></a><code>Year()</code>Return the current persian Year.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int year = pc.Now.Year();       
</pre>
<br /><br /><br />
<a id="gm"></a><code>Month()</code>Return the current persian Month.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int month = pc.Now.Month();       
</pre>
<br /><br /><br />
<a id="gd"></a><code>Day()</code>Return the current persian Day.<br /><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
PersianCalendar pc = new PersianCalendar();

int day = pc.Now.Day();       
</pre>
<br /><br /><br />
<a id="gyo"></a><code>getYearOf()</code>Returns Year for the specified date in persian.<br /><br />
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
<a id="gmo"></a><code>getMonthOf()</code>Returns Month for the specified date in persian.<br /><br />
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
<a id="gdo"></a><code>getDayOf()</code>Returns Day for the specified date in persian.<br /><br />
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
<a id="ey"></a><code>extractYear()</code>Extracts the Year from the given date.<br /><br />
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
<a id="em"></a><code>extractMonth()</code>Extracts the Month from the date.<br /><br />
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
<a id="ed"></a><code>extractDay()</code>Extracts the Day from the date.<br /><br />
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


<a id="jsusage"></a><h1>Javascript</h1>
<pre><script language="javascript" type="text/javascript" src="js/calendar.js"></script></pre><br />

<b>We have 3 categories of methods:</b><br />
<ul>
  <li>Conversion</li>
    <a href="#jsctp"><code>toPersian()</code></a><br />
    <a href="#jsctg"><code>toGregorian()</code></a><br /><br />
  <li><a href="#jsnow">Now</a></li>
  <li>Utilities</li>
    <a href="#jsgda"><code>getDateAt()</code></a><br />
    <a href="#jse"><code>Extract()</code></a><br />
    <a href="#jsgmd"><code>getMaxDay()</code></a><br />
    <a href="#jsgdow"><code>getDayOfWeek()</code></a><br />
    <a href="#jsgly"><code>GregorianLeapYear()</code></a><br />
    <a href="#jsply"><code>PersianLeapYear()</code></a>
</ul>
<br /><br /><br />

<a id="jsctp"></a><code>toPersian()</code> Converting gregorian date to persian date.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day</i><br /><br />
for String format we have separate function. Because functions in Javascript are nonpolymorphic.<br />
<code>toPersianByStr()</code><br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"MM-DD-YYYY"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"MM/DD/YYYY"<br /></i><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
var date = toPersian(1987, 1, 19);
var date = toPersianByStr("1-19-1987");        
</pre>
<br /><br /><br />
<a id="jsctg"></a><code>toGregorian()</code> Converting persian date to gregorian date.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day</i><br />
for String format:<br />
<code>toGregorianByStr()</code><br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>String</i><br /><br />

Eg:
<pre>
var date = toGregorian(1365, 10, 29);
var date = toGregorian("1365/10/29");        
</pre>
<br /><br /><br />
<a id="jsnow"></a><code>Now()</code> Current system date in persian.<br /><br />
Return value: String

Eg:
<pre>
let now = new Now();

alert(now.Today());     //Returns Current persian date as string.
alert(now.Year());      //Returns the Year of current persian date as int.
alert(now.Month());     //Returns the Month of current persian date as int.
alert(now.Day());       //Returns the Day of current persian date as int.
</pre>
<br /><br /><br />
<a id="jsgda"></a><code>getDateAt()</code>Return Year, Month, Day for the specified date in persian.<br /><br />
Arguments:<br />
Integer values for Year, Month and Day<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month, int Day<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
let getDate = new getDateAt(int Year, int Month, int Day);

var year, month, day;
year = getDate.Year();
month = getDate.Month();
day = getDate.Day();
</pre>
<br /><br /><br />

<a id="jse"></a><code>Extract()</code>Extracts the Year, Month, Day from given date.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
let extract = new Extract("1365/10/29");

var year, month, dat;
year = extract.Year();
month = extract.Month();
day = extract.Day();
</pre>
<br /><br /><br />

<a id="jsgmd"></a><code>getMaxDay()</code>Number of days in specified Month.<br /><br />
Arguments:<br />
Integer values for Year and Month<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year, int Month<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
var maxDay = getMaxDay(int Year, int Month);       
</pre>
<br /><br /><br />
<a id="jsgdow"></a><code>getDayOfWeek()</code>Return the Day of week for specified date.<br /><br />
Arguments:<br />
String format as follow<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY-MM-DD"<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"YYYY/MM/DD"<br /></i><br />
Return value: <i>Integer</i><br /><br />

Eg:
<pre>
var weekDay = getDayOfWeek("1365-10-29");       
</pre>
<br /><br /><br />
<a id="jsgly"></a><code>GregorianLeapYear()</code>Return the leap year status for gregorian year.<br /><br />
Arguments:<br />
Integer values for Year<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year<br />
Return value: <i>Boolean</i><br /><br />

Eg:
<pre>
if(GregorianLeapYear(2017)){
    //Do something!
}
</pre>
<br /><br /><br />
<a id="jsply"></a><code>PersianLeapYear()</code>Return the leap year status for persian year.<br /><br />
Arguments:<br />
Integer values for Year<br />
<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int Year<br />
Return value: <i>Boolean</i><br /><br />

Eg:
<pre>
if(PersianLeapYear(1396)){
    //Do something!
}
</pre>