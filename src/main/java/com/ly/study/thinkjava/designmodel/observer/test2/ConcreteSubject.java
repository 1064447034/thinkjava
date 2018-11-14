package com.ly.study.thinkjava.designmodel.observer.test2;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
	private String state;
	private List<Observer> observers;
	
	public ConcreteSubject() {
		observers = new ArrayList<Observer>();
	}
	
	@Override
	public void attach(Observer obv) {
		observers.add(obv);
	}

	@Override
	public void detach(Observer obv) {
		if (!observers.isEmpty()) {
			observers.remove(obv);			
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer ob : observers) {
			ob.update(this);
		}
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getState() {
		return state;
	}

}
