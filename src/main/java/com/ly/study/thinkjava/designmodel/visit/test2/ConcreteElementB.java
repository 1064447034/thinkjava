package com.ly.study.thinkjava.designmodel.visit.test2;

public class ConcreteElementB implements Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.VisitConcreteElementB(this);
	}
	
}
