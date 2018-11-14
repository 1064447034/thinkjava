package com.ly.study.thinkjava.designmodel.decorator;

public class ConcreteComponent implements Component {
	
	@Override
	public void operation() {
		System.out.println("ConcreteComponent Component");
	}
}
