package com.ly.study.thinkjava.guavatest;

import com.google.common.base.Splitter;

public class SplitterTest {
	public static void main(String[] args) {
		System.out.println(Splitter.on("&").withKeyValueSeparator("=").split("id=123&name=zhangsan"));
		
		
	}
}
