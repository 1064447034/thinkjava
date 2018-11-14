package com.ly.study.thinkjava.thread.orderprint.inner_join;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		T1 t1 = new T1();
		T2 t2 = new T2(t1);
		T3 t3 = new T3(t2);
		t2.start();
		t1.start();
		t3.start();
	}

}
