package com.ly.study.thinkjava.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolTest {
	public static void main(String[] args) {

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 1; i < 100; i++)
			executorService.submit(new task());
	}
}

class task implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getId());
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
