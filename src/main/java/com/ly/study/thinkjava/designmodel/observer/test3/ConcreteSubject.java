package com.ly.study.thinkjava.designmodel.observer.test3;

import java.util.Enumeration;
import java.util.Vector;

public class ConcreteSubject implements Subject {
	private Vector observers;
	
	@Override
	public void attach(Observer observer) {
		observers.addElement(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.removeElement(observer);		
	}

	@Override
	public void notifyObservers() {
		Enumeration enumeration = observers.elements();
		while (enumeration.hasMoreElements()) {
			((Observer)(enumeration.nextElement())).update();
		}
	}
	
}
