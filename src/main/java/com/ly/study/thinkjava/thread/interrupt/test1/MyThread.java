package com.ly.study.thinkjava.thread.interrupt.test1;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; ++i) {
			System.out.println("i=" + (i));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
