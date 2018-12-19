package com.ly.study.thinkjava.thread.notify;

public class Blocker {
	synchronized void waitingCall() {
		try {
			while (!Thread.interrupted()) {
				wait();
				System.out.println(Thread.currentThread() + " ");
			}
		} catch (Exception e) {
			
		}
	}
	
	synchronized void prod() {
		notify();
	}
	
	synchronized void prodAll() {
		notifyAll();
	}
}

class Task implements Runnable {
	static Blocker blocker = new Blocker();
	@Override
	public void run() {
		blocker.waitingCall();
	}
}

class Task2 implements Runnable {
	static Blocker blocker = new Blocker();
	@Override
	public void run() {
		blocker.waitingCall();
	}
}
