package com.ly.study.thinkjava.thread.interrupt.test1;

import java.math.BigDecimal;

public class Run {
	public static void main(String[] args) {
		BigDecimal b = new BigDecimal(0.0);
		System.out.println(b.doubleValue() == 0);
		System.out.println(b.intValue() == 0);
		try {
			MyThread thread = new MyThread();
			thread.start();
//			Thread.sleep(2000);
			System.out.println(thread.isInterrupted());
			thread.interrupt();
			System.out.println(thread.isInterrupted());
		} catch (Exception e) {
			System.out.println("main catch");
			e.printStackTrace();
		}

	}
}
