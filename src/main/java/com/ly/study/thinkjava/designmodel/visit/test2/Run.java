package com.ly.study.thinkjava.designmodel.visit.test2;

public class Run {
	public static void main(String[] args) {
		Visitor visitor = new ConcreteVisitorA();
		
		Element ele = new ConcreteElementA();
		ele.accept(visitor);
		
	}
}
