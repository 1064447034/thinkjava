package designpattern.observer.test3;

public class ConcreteObserver implements Observer {
	@Override
	public void update() {
		System.out.println("i am notified");
	}
	
}
