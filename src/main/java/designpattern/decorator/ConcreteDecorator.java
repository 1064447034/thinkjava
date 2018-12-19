package designpattern.decorator;

public class ConcreteDecorator extends Decorator {
	public ConcreteDecorator(Component com) {
		super(com);
	}
	
	@Override
	public void operation() {
		this.addBehavior();
		super.operation();
	}

	public void addBehavior() {
		System.out.println("ConcreteDecorator Component");
	}
}
