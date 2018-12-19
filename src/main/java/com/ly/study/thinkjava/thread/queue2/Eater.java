package com.ly.study.thinkjava.thread.queue2;

public class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int count = 0;
	public Eater(ToastQueue finished) {
		this.finishedQueue = finished;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast t = finishedQueue.take();
				if (t.getId() != count++ || t.getStatus() != Toast.Status.JAMMED) {
					System.out.println("error: " + t);
					System.exit(1);
				} else {
					System.out.println("chomp!" + t); 
				}
			}
		} catch (Exception e) {
			System.out.println("eater interrupted");
		}
		System.out.println("eater off");
	}
}
