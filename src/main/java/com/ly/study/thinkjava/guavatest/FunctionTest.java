package com.ly.study.thinkjava.guavatest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;


public class FunctionTest {
	public static void main(String[] args) {	
		System.out.println(new DateFormatFunction().apply(new Date()));
		Function<Date, String> f = new Function<Date, String>() {
			@Override
			public String apply(Date arg0) {
				return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(arg0);
			}
		};
		System.out.println(f.apply(new Date()));
		
	}
}

class DateFormatFunction implements Function<Date, String> {
	@Override
	public String apply(Date arg0) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(arg0);
	}
}