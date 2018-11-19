package designpattern.observer.test2;

public class ConcreteObserverA implements Observer {
	private Subject subject;
	private String state;
	
	public ConcreteObserverA(Subject subject) {
		this.subject = subject;
		subject.attach(this);
	}
	
	public void removeObserver() {
		subject.detach(this);
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	@Override
	public void update(Subject sub) {
		state = sub.getState();
		this.printInfo();
	}

	public void printInfo() {
		System.out.println("ConcreteObserverA observer：" + subject.getState());
	}
	
}
