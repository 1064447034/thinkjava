package com.ly.study.thinkjava.sync;

import java.text.SimpleDateFormat;

public class Demo3 {
	public static void main(String[] args) {
		dateFormat.set(new SimpleDateFormat());
		System.out.println(dateFormat.get());
	}
	public static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	
}
