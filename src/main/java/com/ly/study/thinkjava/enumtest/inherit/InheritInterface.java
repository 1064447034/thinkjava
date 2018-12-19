package com.ly.study.thinkjava.enumtest.inherit;

interface Funnel<T> {
	void funnel(T from);
}

enum IntegerFunnel implements Funnel<Integer> {
	INSTANCE;

	@Override
	public void funnel(Integer from) {
		System.out.println(from);
	}
}

enum IntegerFunnel2 implements Funnel<Integer> {
	INSTANCE() {
		@Override
		public void funnel(Integer from) {
			System.out.println(from);
		}
	}
}

public class InheritInterface {
	public static Funnel<Integer> integerFunnel() {
		return IntegerFunnel.INSTANCE;
	}
	
	public static Funnel<Integer> integerFunnel2() {
		return IntegerFunnel2.INSTANCE;
	}
	
	public static void main(String[] args) {
		integerFunnel().funnel(1234);
		integerFunnel2().funnel(5542);
	}
}