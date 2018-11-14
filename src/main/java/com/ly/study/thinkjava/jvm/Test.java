package com.ly.study.thinkjava.jvm;

public class Test {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			new Thread() {
				@Override
				public void run() {
					try {
						Thread.sleep(100000);
					} catch (Exception e) {
					}
				};
			}.start();
		}
		
		Thread t = new Thread() {
			@Override
			public void run() {
				int i = 0;
				while (true) {
					i = (i++) / 100;
				}
			}
		};
		t.setName("Business thread");
		t.start();
	}
}
