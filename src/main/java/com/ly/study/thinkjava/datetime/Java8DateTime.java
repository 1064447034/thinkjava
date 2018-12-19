package com.ly.study.thinkjava.datetime;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

//import org.joda.time.format.DateTimeFormat;
//import org.joda.time.format.DateTimeFormatter;
import org.junit.Ignore;
import org.junit.Test;

public class Java8DateTime {
	@Test
	@Ignore
	public void testCalendar() throws Exception {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-07-06 08:22:23");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +cal.get(Calendar.DAY_OF_MONTH));
	}
	
	@Test
	public void testJava8DateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime ldt = LocalDateTime.parse("2017-07-05 20:23:33", formatter);
		System.out.println(ldt.getYear() + "-" + ldt.getMonthValue() + "-" + ldt.getDayOfMonth());
		
	}
/*
	@Test
	public void testJodaTime() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
		LocalDate localDate = formatter.parseLocalDate("2015-09-17 20:23:05");
		System.out.println(localDate.getYear() + "-" + localDate.getMonthOfYear() + "-" + localDate.getDayOfMonth());
	}
*/
	@Test
	public void testClock() {
		Clock c1 = Clock.systemUTC();
		System.out.println(c1.millis());
		
		LocalDate ld = LocalDate.parse("2013-11-05");
		System.out.println(ld.getYear());
	}
}
