package com.ly.study.thinkjava.designmodel.observer.test4;

public class ConcreteObserver implements Observer {
	@Override
	public void update() {
		System.out.println("i am notified");
	}
	
}
