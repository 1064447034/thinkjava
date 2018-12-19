package com.ly.study.thinkjava.forkjoin;

public class Test {
	public static void main(String[] args) {
		try {
			System.out.println(func());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	static int func() {
		try {
			int i = 10;
			int j = 0;
			return i / j;
		} finally {
			System.out.println("finally");
		}
	}
}
