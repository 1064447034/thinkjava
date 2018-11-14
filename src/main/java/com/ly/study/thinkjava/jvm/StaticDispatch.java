package com.ly.study.thinkjava.jvm;

public class StaticDispatch {
	static abstract class Human {
	}
	
	static class Man extends Human {
	}

	static class WoMan extends Human {
	}

	public void sayHello(Human guy) {
		System.out.println("hello, guy!");
	}
	
	public void sayHello(Man guy) {
		System.out.println("hello, gentleman!");
	}
	
	public void sayHello(WoMan guy) {
		System.out.println("hello, lady!");
	}
	
	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new WoMan();
		StaticDispatch sr = new StaticDispatch();
		sr.sayHello(man);
		sr.sayHello(woman);
	}
}
