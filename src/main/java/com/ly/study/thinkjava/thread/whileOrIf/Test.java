package com.ly.study.thinkjava.thread.whileOrIf;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		final Buf buf = new Buf();
		ExecutorService exec = Executors.newFixedThreadPool(11);
		
		ScheduledExecutorService sexec = Executors.newScheduledThreadPool(1);
		sexec.scheduleAtFixedRate(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println(buf.size());
		    }
		}, 0, 1, TimeUnit.SECONDS);
		
		for (int i = 0; i < 1; ++i) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							buf.put(1);
							Thread.sleep(10);
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
			});
		}
		
		for (int i = 0; i < 10; ++i) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							buf.get();
							Thread.sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
							break;
						}
					}
				}
			});
		}
		exec.shutdown();
		exec.awaitTermination(1, TimeUnit.DAYS);
	}
}
