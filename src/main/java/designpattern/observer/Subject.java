package designpattern.observer;

import java.util.List;

public abstract class Subject {
	protected List<Observer> observers;

	public List<Observer> getObservers() {
		return observers;
	}
	public void setObservers(List<Observer> observers) {
		this.observers = observers;
	}

	public void attach(Observer obv) {
		observers.add(obv);
	}

	public void detach(Observer obv) {
		if (obv != null) {
			observers.remove(obv);
		}
	}
	
	public void notifyObserver() {
		for (Observer ob : observers) {
			ob.update(this);
		}
	}
	
	public abstract void setState(String st);
	public abstract String getState();
	
}
