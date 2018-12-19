package com.ly.study.thinkjava.thread.orderprint.wait_nofity;

public class ThreadAA extends Thread {
	private MyService dbtools;
	 
	public ThreadAA(MyService dbtools) {
		super();
		this.dbtools = dbtools;
	}
 
	@Override
	public void run() {
		dbtools.methodA();
	}

}
