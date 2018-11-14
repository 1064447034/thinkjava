package com.ly.study.thinkjava.designmodel.observer.test4;

import java.util.Enumeration;
import java.util.Vector;

public abstract class Subject {
	private Vector observers = new Vector();
	
	public void attach(Observer observer) {
		observers.addElement(observer);
		System.out.println("attached an observer");
	}
	
	public void detach(Observer observer) {
		observers.removeElement(observer);
		System.out.println("detach an observer");
	}
	
	public void notifyObservers() {
		Enumeration enumeration = observers.elements();
		while (enumeration.hasMoreElements()) {
			((Observer)(enumeration.nextElement())).update();
		}
	}
	
	
}
