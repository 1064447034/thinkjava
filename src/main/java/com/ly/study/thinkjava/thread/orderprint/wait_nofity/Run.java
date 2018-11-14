package com.ly.study.thinkjava.thread.orderprint.wait_nofity;

public class Run {
	public static void main(String[] args) {
		MyService myService = new MyService();
		for (int i = 0; i < 2; i++) {
			ThreadBB output = new ThreadBB(myService);
			output.start();
			ThreadAA input = new ThreadAA(myService);
			input.start();
            ThreadCC threadCC = new ThreadCC(myService);
            threadCC.start();
		}
	}

}
