package com.ly.study.thinkjava.designmodel.observer.test2;

public interface Subject {
	public void attach(Observer obv);
	public void detach(Observer obv);
	public void notifyObserver();
	public void setState(String state);
	public String getState();
	
}
