package com.ly.study.thinkjava.clone;

public class Human implements Cloneable {
	 int age;

	public Human(int age) {
		super();
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public Human clone() throws CloneNotSupportedException {
		Human h = (Human)super.clone();
		return h;
	}
}