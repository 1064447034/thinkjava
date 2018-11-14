package com.ly.study.thinkjava.designmodel.visit.test1;

public class ConcreteElement1 implements Element {
	@Override
	public void accept(IVistor vistor) {
		vistor.visit(this);
	}
	
	@Override
	public void doSomethind() {
		System.out.println("element 1");
	}
}
