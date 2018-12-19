package com.ly.study.thinkjava.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class WaitingTask implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final CountDownLatch latch;
	
	public WaitingTask(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			latch.await();
			TimeUnit.MILLISECONDS.sleep(1000);
			System.out.println("latch barrier passed for " + this);
		} catch (Exception e) {
			System.out.println(this + " interrupted");
		}
	}
	
	@Override
	public String toString() {
		return String.format("waitingTask %1s-3d", id);
	}
}
