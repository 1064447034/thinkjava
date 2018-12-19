package com.ly.study.thinkjava.sync;

class SyncThread implements Runnable {
	private static int count;
	public SyncThread() {
		count = 0;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 20; ++i) {
				try {
					System.out.println(Thread.currentThread().getName() + ": " + (count++));
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}

public class Demo1 {
	public static void main(String[] args) {
		SyncThread sync1 = new SyncThread();
		SyncThread sync2 = new SyncThread();
		Thread thread1 = new Thread(sync1, "syncThread1");
		Thread thread2 = new Thread(sync2, "syncThread2");
		thread1.start();
		thread2.start();
	}
}
