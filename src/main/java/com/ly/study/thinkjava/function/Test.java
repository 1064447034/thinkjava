package com.ly.study.thinkjava.function;

import java.util.function.Function;

public class Test {
	public  <T> T invokeMethod(String param, Function<Base<String>, T> invoke) {
		Base<String> child = new Child();
		return invoke.apply(child);
	}
	
	public static void main(String[] args) {
		new Test().exec();
	}
	
	public void exec() {
		System.out.println(invokeMethod("abc", (x)->this.<Child<String>>castCommand(x).print()));
	}
	
	protected  <T> T castCommand(Base base) {
		return (T)base;
	}
	
}

interface Base<T> {
	public String print();
}

class Child<T> implements Base<T> {
	@Override
	public String print() {
		return "child1";
	}
}
