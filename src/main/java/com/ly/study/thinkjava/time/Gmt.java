package com.ly.study.thinkjava.time;

import java.util.Calendar;

public class Gmt {
	public static void main(String[] args) throws InterruptedException {
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2003,7,31,0,0,0);
		System.out.println(cal2.getTime());
		
		System.out.println(System.currentTimeMillis());
		Thread.sleep(5000);
		System.out.println(System.currentTimeMillis());
	}
}
