package com.ly.study.thinkjava.designmodel.observer.test2;

public class ConcreteObserverB implements Observer {
	private Subject subject;
	private String state;
	
	public ConcreteObserverB(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	public void removeObserver() {
		subject.detach(this);
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	@Override
	public void update(Subject sub) {
		state = sub.getState();
		this.printInfo();
	}

	public void printInfo() {
		System.out.println("ConcreteObserverB observer：" + subject.getState());
	}
	
}
