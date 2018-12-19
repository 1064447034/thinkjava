package com.ly.study.thinkjava.thread.queue2;

public class Jammer implements Runnable {
	private ToastQueue butteredQueue, finishedQueue;
	
	public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
		this.butteredQueue = butteredQueue;
		this.finishedQueue = finishedQueue;
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
			}
		} catch (Exception e) {
			System.out.println("Jammer interrupted");
		}
		System.out.println("jamer off");
	}
}
