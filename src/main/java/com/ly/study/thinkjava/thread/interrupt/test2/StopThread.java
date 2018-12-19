package com.ly.study.thinkjava.thread.interrupt.test2;

import java.util.concurrent.TimeUnit;

public class StopThread implements Runnable {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println(Thread.currentThread().getName() + " 运行中");
		}
		System.out.println(Thread.currentThread().getName() + "退出");
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new StopThread());
		t.start();
		System.out.println("main run");
		TimeUnit.MILLISECONDS.sleep(10);
		t.interrupt();
	}
	
}
