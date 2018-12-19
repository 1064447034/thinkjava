package designpattern.observer.test4;

public class Main {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		Observer observer = new ConcreteObserver();
		subject.attach(observer);
		subject.change("new state");
	
	}
}
