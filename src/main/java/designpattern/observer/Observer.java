package designpattern.observer;

public abstract class Observer {
	private String st;
	
	public abstract void update(Subject sub);
	
	public abstract void printInfo();
	
}
