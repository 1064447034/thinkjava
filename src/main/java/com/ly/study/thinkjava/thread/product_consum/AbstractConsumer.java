package com.ly.study.thinkjava.thread.product_consum;

public abstract class AbstractConsumer implements Consumer, Runnable {
	@Override
	public void run() {
		while (true) {
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
