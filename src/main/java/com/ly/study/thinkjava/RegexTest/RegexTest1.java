package com.ly.study.thinkjava.RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest1 {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("w(or)(ld!)");
		Matcher m = p.matcher("Hello, world! in java.");
//		System.out.println(m.find());
//		System.out.println(m.groupCount());
//		System.out.println();
		
		while (m.find()) {
			System.out.print(m.start() + " ");
			System.out.print(m.end() + " ");
			System.out.println(m.group());
			
			System.out.print(m.start(0) + " ");
			System.out.print(m.end(0) + " ");
			System.out.println(m.group(0));
			
			System.out.print(m.start(1) + " ");
			System.out.print(m.end(1) + " ");
			System.out.println(m.group(1));
			
			System.out.print(m.start(2) + " ");
			System.out.print(m.end(2) + " ");
			System.out.println(m.group(2));
		}
//		System.out.println(m.start());
//		System.out.println(m.start(0));
//		System.out.println(m.start(1));
//		System.out.println(m.start(2));
//		System.out.println();
//		
//		System.out.println(m.end());
//		System.out.println(m.end(0));
//		System.out.println(m.end(1));
//		System.out.println(m.end(2));
//		System.out.println();
//		
//		System.out.println(m.group(0));
//		System.out.println(m.group(1));
//		System.out.println(m.group(2));
	}
	
	@Test
	public void getTicketNum() {
		Pattern p = Pattern.compile("\\d*");
		Matcher m = p.matcher("3张");
		System.out.println(m.group());
	}
	@Test
	public void getTicketNum2() {
		String str = " 1000万元2333张3355";
	    String regex = "\\d*";
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(str);
	    while(m.find()) {
//	        if(!"".equals(m.group()))
            System.out.println(m.group());
	    }
	}
}