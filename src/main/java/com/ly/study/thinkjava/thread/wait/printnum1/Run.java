package com.ly.study.thinkjava.thread.wait.printnum1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Run {
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();
	private static int num = 0;
	
	public static void main(String[] args) {
		new Thread(new Odd()).start();
		new Thread(new Even()).start();
	}
	
	static class Odd implements Runnable {
		@Override
		public void run() {
			while (true) {
				lock.lock();
				try {
					Thread.sleep(1000);
					while (num % 2 != 0) {
						condition.await();
					}
					System.out.println("Odd: " + num);
//					num = new Random(100).nextInt();
					num++;
					condition.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}
	static class Even implements Runnable {
		@Override
		public void run() {
			while (true) {
				lock.lock();
				try {
					Thread.sleep(1000);
					while (num % 2 == 0) {
						condition.await();
					}
					System.out.println("EVen: " + num);
//					num = new Random(100).nextInt();
					num++;
					condition.signal();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}
	}
}
