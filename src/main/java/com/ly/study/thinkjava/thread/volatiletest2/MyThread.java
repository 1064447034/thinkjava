package com.ly.study.thinkjava.thread.volatiletest2;

public class MyThread extends Thread {
	public volatile static int count;
	private synchronized static void addCount() {
		for (int i = 0; i < 100; ++i) {
			count++;
		}
		System.out.println("count=" + count);
	}
	
	@Override
	public void run() {
		addCount();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
