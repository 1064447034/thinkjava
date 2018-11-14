package com.ly.study.thinkjava.designmodel.decorator;

public class ConcreteDecorator2 extends Decorator {
	private Component com;
	public ConcreteDecorator2(Component com) {
		super(com);
	}
	
	@Override
	public void operation() {
		super.operation();
	}
	
	public void addBehavior() {
		System.out.println("ConcreteDecorator Component");
	}
}
