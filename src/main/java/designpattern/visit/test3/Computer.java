package designpattern.visit.test3;

public interface Computer {
	void accept(Visitor visitor);
	
	void doAction();
}
