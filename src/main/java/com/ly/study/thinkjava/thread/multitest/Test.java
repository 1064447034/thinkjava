package com.ly.study.thinkjava.thread.multitest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Number number = new Number();
		for (int i = 0; i < 50; ++i) {
			exec.execute(new Number());
		}
	}
}
