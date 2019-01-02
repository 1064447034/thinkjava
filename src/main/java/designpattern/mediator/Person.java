package designpattern.mediator;

public abstract class Person {
	protected String name;
	protected QQqun qun;
	
	public Person(String name, QQqun qun) {
		this.name = name;
		this.qun = qun;
	}
	
	public void addQun() {
		qun.addPerson(this);
	}
	
	abstract void talk(String message);
}
