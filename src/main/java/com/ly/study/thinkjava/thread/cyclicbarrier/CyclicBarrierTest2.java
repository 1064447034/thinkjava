package com.ly.study.thinkjava.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
	static CyclicBarrier c = new CyclicBarrier(3, new A());
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				
				System.out.println(1);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
					Thread.sleep(4000);
				} catch (Exception e) {
				}
				System.out.println(2);
			}
		}).start();
		try {
			c.await();
			Thread.sleep(4000);
		} catch (Exception e) {
		}
		System.out.println(3);
	}
	
	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println(4);
		}
	}
}
