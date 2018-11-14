package com.ly.study.thinkjava.designmodel.observer.test2;

public class Main {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		Observer o1 = new ConcreteObserverA(subject);
		Observer o2 = new ConcreteObserverB(subject);
		subject.setState("old");
		subject.notifyObserver();
		subject.setState("new");
		subject.notifyObserver();
		
	}
}
