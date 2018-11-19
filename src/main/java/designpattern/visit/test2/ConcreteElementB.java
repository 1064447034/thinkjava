package designpattern.visit.test2;

public class ConcreteElementB implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.VisitConcreteElementB(this);
	}
	
}
