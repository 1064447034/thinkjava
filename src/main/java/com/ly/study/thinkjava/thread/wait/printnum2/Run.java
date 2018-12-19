package com.ly.study.thinkjava.thread.wait.printnum2;

class PrintNum {
	private int num;
	
	public void even() {
		while (num <= 100) {
			synchronized(PrintNum.class) {
				if (num % 2 == 0) {
					System.out.println("even: " + num);
					num++;
					PrintNum.class.notify();
				} else {
					try {
						PrintNum.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	public void odd() {
		while (num <= 100) {
			synchronized(PrintNum.class) {
				if (num % 2 != 0) {
					System.out.println("odd: " + num);
					num++;
					PrintNum.class.notify();
				} else {
					try {
						PrintNum.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}

class MyThread1 implements Runnable {
	private PrintNum printNum;
	public MyThread1(PrintNum printNum) {
		this.printNum = printNum;
	}
	
	@Override
	public void run() {
		printNum.even();
	}
}

class MyThread2 implements Runnable {
	private PrintNum printNum;
	public MyThread2(PrintNum printNum) {
		this.printNum = printNum;
	}
	@Override
	public void run() {
		printNum.odd();
	}
}

public class Run {
	public static void main(String[] args) {
		PrintNum p = new PrintNum();
		new Thread(new MyThread1(p)).start();
		new Thread(new MyThread2(p)).start();
	}
}
