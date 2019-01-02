package designpattern.mediator;

public class ZhangSan extends Person {
	public ZhangSan(String name, QQqun qun) {
		super(name, qun);
	}
	
	void exchange(String message) {
		qun.exchange(this, message);
	}
	
	void talk(String message) {
		System.out.println(name + " 说：" + message);
	}
	
}
