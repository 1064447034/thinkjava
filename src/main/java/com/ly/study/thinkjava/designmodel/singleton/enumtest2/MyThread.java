package com.ly.study.thinkjava.designmodel.singleton.enumtest2;

public class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			System.out.println(MyObject.getConnection().hashCode());
		}
	}
	
}
