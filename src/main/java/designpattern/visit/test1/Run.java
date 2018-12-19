package designpattern.visit.test1;

public class Run {
	public static void main(String[] args) {
		Element e = new ConcreteElement1();
		e.accept(new Vistor());
		
	}
}
