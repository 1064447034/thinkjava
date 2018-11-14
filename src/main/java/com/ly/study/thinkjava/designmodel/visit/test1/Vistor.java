package com.ly.study.thinkjava.designmodel.visit.test1;

public class Vistor implements IVistor {
	@Override
	public void visit(Element e1) {
		e1.doSomethind();
	}
	
}
