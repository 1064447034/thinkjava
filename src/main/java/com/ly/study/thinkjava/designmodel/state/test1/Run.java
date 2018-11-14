package com.ly.study.thinkjava.designmodel.state.test1;

public class Run {
	public static void main(String[] args) {
		Switcher s = new Switcher();
		s.switchOff();
		s.switchOn();
		s.switchOn();
		s.switchOff();
		s.switchOff();
	}
}	
