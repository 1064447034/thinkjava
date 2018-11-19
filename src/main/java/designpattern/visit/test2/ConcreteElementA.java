package designpattern.visit.test2;

public class ConcreteElementA implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.VisitConcreteElementA(this);
	}
	
}
