package com.ly.study.thinkjava.thread.orderprint.wait_nofity;

public class ThreadCC extends Thread {
	private MyService dbtools;
	 
	public ThreadCC(MyService dbtools) {
		this.dbtools = dbtools;
	}
 
	@Override
	public void run() {
		dbtools.methodC();
	}

}
