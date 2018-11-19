package designpattern.visit.test1;

public class ConcreteElement2 implements Element {
	@Override
	public void accept(IVistor vistor) {
		vistor.visit(this);
	}
	
	@Override
	public void doSomethind() {
		System.out.println("element 2");
	}
}
