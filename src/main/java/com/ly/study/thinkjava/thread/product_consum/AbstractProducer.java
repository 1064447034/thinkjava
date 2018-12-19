package com.ly.study.thinkjava.thread.product_consum;

public abstract class AbstractProducer implements Producer, Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
