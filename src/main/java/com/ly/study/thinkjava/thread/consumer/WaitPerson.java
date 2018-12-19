package com.ly.study.thinkjava.thread.consumer;

public class WaitPerson implements Runnable {
	private Restaurant restaurant;
	public WaitPerson(Restaurant r) {
		this.restaurant = r;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized(this) {
					while (restaurant.meal == null) {
						wait();
					}
				}
				System.out.println("waitperson got " + restaurant.meal);
				synchronized(restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notify();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
