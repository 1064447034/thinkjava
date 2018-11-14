package com.ly.study.thinkjava.designmodel.visit.test2;

public class ConcreteVisitorA implements Visitor {
	@Override
	public void VisitConcreteElementA(Element elm) {
		System.out.println("ConcreteVisitorA");
	}

	@Override
	public void VisitConcreteElementB(Element elm) {
		System.out.println("ConcreteVisitorB");
	}
	
}
