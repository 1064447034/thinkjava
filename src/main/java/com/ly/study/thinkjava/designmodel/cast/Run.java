package com.ly.study.thinkjava.designmodel.cast;

public class Run {
	public static void main(String[] args) {
		Horse h = new BlackHorse();
		WhiteHorse w = (WhiteHorse)h;
		w.sys();
	}
}
