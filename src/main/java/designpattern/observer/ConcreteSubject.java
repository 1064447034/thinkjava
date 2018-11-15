package designpattern.observer;

import java.util.List;

public class ConcreteSubject extends Subject {
	private String state;
	
	@Override
	public void setState(String st) {
		this.state = st;
	}

	@Override
	public String getState() {
		return state;
	}
	
}
