package designpattern.observer.test4;

public class ConcreteSubject extends Subject {
	private String state;
	
	public void change(String state) {
		this.state = state;
		this.notifyObservers();
	}
}
