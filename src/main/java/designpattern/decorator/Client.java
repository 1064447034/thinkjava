package designpattern.decorator;

public class Client {
	public static void main(String[] args) {
		Component com = new ConcreteComponent();
		Decorator doc = new ConcreteDecorator(com);
		Decorator doc2 = new ConcreteDecorator2(doc);
		doc2.operation();
	}
}
