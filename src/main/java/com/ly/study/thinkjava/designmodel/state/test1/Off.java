package com.ly.study.thinkjava.designmodel.state.test1;

public class Off implements State {
	 @Override
	 public void switchOn(Switcher switcher) {
	     switcher.setState(new On());
	     System.out.println("OK...灯亮");
	 }
	 
	 @Override
	 public void switchOff(Switcher switcher) {
	     System.out.println("WARN!!!断电状态无需再关");
	     return;
	 }
}
