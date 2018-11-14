package com.ly.study.thinkjava.datetime;

import java.util.Calendar;

public class DaysBetween {
	public static void main(String[] args) {
	    Calendar birth = Calendar.getInstance();
	    birth.set(1975, Calendar.MAY, 26);
	    Calendar now = Calendar.getInstance();
	    System.out.println(daysBetween(birth, now));
	    System.out.println(daysBetween(birth, now)); // 显示 0？
	}  
	 
	public static long daysBetween(Calendar begin, Calendar end) {
		Calendar cal = (Calendar)begin.clone();
	    long daysBetween = 0;
	    while(cal.before(end)) {
	    	cal.add(Calendar.DAY_OF_MONTH, 1);
	        daysBetween++;
	    }
	    return daysBetween;
	}
	
	
}
