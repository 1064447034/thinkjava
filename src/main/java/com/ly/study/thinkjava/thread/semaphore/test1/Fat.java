package com.ly.study.thinkjava.thread.semaphore.test1;

public class Fat {
	private volatile double d;
	private static int counter = 0;
	private final int id = counter++;
	public Fat() {
		for (int i = 0; i < 1000; ++i) {
			d += (Math.PI + Math.E) / i;
		}
	}
	public void operation() {
		System.out.println(this);
	}
	@Override
	public String toString() {
		return "Fat id: " + id;
	}
}
