package com.ly.study.thinkjava.thread.orderprint.join;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		T11 t1 = new T11();
		T22 t2 = new T22();
		T33 t3 = new T33();
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
	}

}
