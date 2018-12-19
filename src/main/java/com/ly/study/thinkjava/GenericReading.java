package com.ly.study.thinkjava;

import java.util.Arrays;
import java.util.List;

class Apple {}
class Fruit {}

class Holder<T> {
	private T value;
	public Holder() {}
	public Holder(T val) {
		value = val;
	}
	public void set(T val) {
		value = val;
	}
	public T get() {
		return value;
	}
	@Override
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
}

public class GenericReading {
	static <T> T readExact(List<T> list) {
		return list.get(0);
	}
	
	static List<Apple> apples = Arrays.asList(new Apple());
	static List<Fruit> fruit = Arrays.asList(new Fruit());
	
	static void f1() {
		Apple a = readExact(apples);
		Fruit f = readExact(fruit);
//		f = readExact(apples);
	}
	
	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}
	
	static void f2() {
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		Fruit f = fruitReader.readExact(fruit);
	}
	
	static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
		T t = holder.get();
		return t;
	} 
}
