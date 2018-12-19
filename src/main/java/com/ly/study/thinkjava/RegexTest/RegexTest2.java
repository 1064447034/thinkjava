package com.ly.study.thinkjava.RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class RegexTest2 {
	public static void main(String[] args) {
		String s = "<h3 class=\"orange bold\">总计：1人<span><b>￥4790.0(机票)</b></span></h3>";
		Pattern p = Pattern.compile("(\\d+(\\.\\d+)?)");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group());
			System.out.println(m.group(0));
		}
		
		System.out.println(StringUtils.substringBetween(s, "￥", "(机票)"));
	}
}
