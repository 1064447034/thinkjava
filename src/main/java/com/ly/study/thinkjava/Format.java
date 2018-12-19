package com.ly.study.thinkjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

public class Format {
	public static void main(String[] args) throws InterruptedException, ParseException {
		System.out.println(String.format("系统下单重试[%d]", 12));
		
		int reTry = 4;
		int i = 0;
		while (i++ < reTry) {
//			Thread.sleep(5000);
			System.out.println(i);
		}
		
		try {
			Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse("20170620101223");
			System.out.println(date);
			System.out.println(date.getTime());
		} catch (Exception e) {
			System.out.println(e);
		}
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.getMinimum(Calendar.MONTH));
		
		cal.setLenient(true);
		cal.set(Calendar.MONTH, 13);
		System.out.println(cal.getTime());
		
		List<String> lst = new ArrayList<>();
		lst.add("aaaaa");
		lst.add("bbbbb");
		lst.add("ccccc");
		lst.add("ddddd");
		lst.add("eeeee");
		
		ListIterator<String> lstIter = lst.listIterator();
		
		while (lstIter.hasNext()) {
			String item = lstIter.next();
			System.out.println(item);
			lstIter.remove();
			System.out.println(lst);
		}
	}
}
