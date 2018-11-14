package com.ly.study.thinkjava.thread.compare1;

public class SynchronizingTest extends Incrementable {
	@Override
	public synchronized void increment() {
		++counter;
	}
}
