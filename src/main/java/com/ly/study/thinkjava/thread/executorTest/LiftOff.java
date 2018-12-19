package com.ly.study.thinkjava.thread.executorTest;

public class LiftOff implements Runnable {
	protected int countDown = 10;
	private static int tastCount = 0;
	private final int id = tastCount++;
	public LiftOff() {
		// TODO Auto-generated constructor stub
	}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")."; 
	}
	
	@Override
	public void run() {
		while (countDown-- > 0) {
			try {
				Thread.sleep(1000);
//				Thread.yield();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(status());
		}
	}
}
