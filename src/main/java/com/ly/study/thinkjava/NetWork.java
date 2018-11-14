package com.ly.study.thinkjava;

public class NetWork extends Child {
	public static void main(String[] args) {
		new NetWork().childFunc();
		new NetWork().func();
		new InterfaceAImpl().func();
	}
}

class Parent {
	protected void func() {
		System.out.println("protected");
	}
}

class Child extends Parent {
	protected void childFunc() {
		System.out.println("child");
	}
}

abstract interface InterfaceA {
	public abstract void func();
}
 
class InterfaceAImpl implements InterfaceA {
	@Override
	public void func() {
		System.out.println("InterfaceImpl");
		
	}
}