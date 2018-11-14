package com.ly.study.thinkjava.thread.queue1;

import java.util.concurrent.BlockingQueue;

public class LiftOffRunner implements Runnable {
	private BlockingQueue<LiftOff> rockets;
	public LiftOffRunner(BlockingQueue<LiftOff> lo) {
		this.rockets = lo;
	}
	
	public void add(LiftOff lo) {
		try {
			rockets.put(lo);
		} catch (Exception e) {
			System.out.println("Interrupt during put()");
		}
	}
	
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (Exception e) {
			System.out.println("waking from take()");
		}
		System.out.println("exiting LiftOffRunner");
	}
}
