package com.ly.study.thinkjava.thread.queue2;

public class Butterer implements Runnable{
	private ToastQueue dryQueue, butteredQueue;
	public Butterer(ToastQueue dry, ToastQueue buttered) {
		this.dryQueue = dry;
		this.butteredQueue = buttered;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = dryQueue.take();
				t.buffer();
				System.out.println(t);
				butteredQueue.put(t);
			}
		} catch (Exception e) {
			System.out.println("butterer interrupt");
		}
		System.out.println("butterer off");
	}
}
