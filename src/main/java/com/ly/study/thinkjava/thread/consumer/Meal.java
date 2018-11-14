package com.ly.study.thinkjava.thread.consumer;

public class Meal {
	private final int orderNum;
	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "Meal " + orderNum;
	}
}
