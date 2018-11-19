package designpattern.decorator;

public abstract class Decorator implements Component {
	private Component com;
	public Decorator(Component com) {
		this.com = com;
	}
	
	@Override
	public void operation() {
		com.operation();
	}
}
