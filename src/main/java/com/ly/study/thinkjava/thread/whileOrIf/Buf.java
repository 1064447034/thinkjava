package com.ly.study.thinkjava.thread.whileOrIf;

import java.util.ArrayList;
import java.util.List;

public class Buf {
	private final int MAX = 5;
	private final List<Integer> list = new ArrayList<>();
	
	synchronized void put(int v) throws InterruptedException {
		while (list.size() == MAX) {
			wait();
		}
		list.add(v);
		notify();
	}
	
	synchronized int get() throws InterruptedException {
		while (list.size() == 0) {
			wait();
		}
		int v = list.remove(0);
		notify();
		return v;
	}
	
	synchronized int size() {
		return list.size();
	}
}
