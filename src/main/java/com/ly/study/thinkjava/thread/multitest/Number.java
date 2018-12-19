package com.ly.study.thinkjava.thread.multitest;

public class Number implements Runnable {
	private int number = 0;
	@Override
	public void run() {
		int i = 0;
		while (i < 100000) {
			int n = getValue();
			if (n % 2 != 0) {
				System.out.println(n);
				i = 100000;
			}
			++i;
		}
	}
	
	private int getValue() {
		++number;
		++number;
		return number;
	}
}
