package com.ly.study.thinkjava.thread.product_consum;

public class Main {
	public static void main(String[] args) {
		Model model = new WaitNotifyModel(1);
		for (int i = 0; i < 2; i++) {
			new Thread(model.newRunnableConsumer()).start();
		}
		
		for (int i = 0; i < 5; ++i) {
			new Thread(model.newRunnableProducer()).start();
		}
	}
}
