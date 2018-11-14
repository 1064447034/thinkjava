package com.ly.study.thinkjava.thread.volatiletest1;

public class Run {
	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();
		
		printStringService.printStringMethod();
		System.out.println("停止它！ stopThread=" + Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
		
	}
}
