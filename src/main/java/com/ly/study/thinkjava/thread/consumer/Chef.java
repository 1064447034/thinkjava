package com.ly.study.thinkjava.thread.consumer;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;
	public Chef(Restaurant r) {
		this.restaurant = r;
	}
	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized(this) {
					while (restaurant.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("order Up...");
				synchronized(restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (Exception e) {
			System.out.println("chef interrupted");
		}
	}
}
