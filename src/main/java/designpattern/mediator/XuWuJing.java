package designpattern.mediator;

public class XuWuJing extends Person {
	public XuWuJing(String name, QQqun qun) {
		super(name, qun);
	}
	
	void exchange(String message) {
		qun.exchange(this, message);
	}
	
	void talk(String message) {
		System.out.println(name + " 回应：" + message);
	}
}
