package com.ly.study.thinkjava.thread.queue2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random random = new Random(47);
	public Toaster(ToastQueue tq) {
		this.toastQueue = tq;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
				Toast t = new Toast(count++);
				System.out.println(t);
				toastQueue.put(t);
			}
		} catch (Exception e) {
			System.out.println("toaster interrupted");
		}
		System.out.println("toaster off");
	}
}
