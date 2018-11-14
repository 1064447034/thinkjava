package com.ly.study.thinkjava.thread.volatiletest2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
	public static void main(String[] args) {
//		new Thread(new MyThread()).start();
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; ++i) {
			exec.execute(new MyThread());			
		}
	}
}
