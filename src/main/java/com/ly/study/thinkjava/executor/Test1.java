package com.ly.study.thinkjava.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
 	public static void main(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; ++i) {
			int index = i;
			try {
				Thread.sleep(index * 10000);
			} catch (Exception e) {

			}
			cachedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(index);
				}
			});
			cachedThreadPool.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println(index);
				}
			});
		}
	}
}
