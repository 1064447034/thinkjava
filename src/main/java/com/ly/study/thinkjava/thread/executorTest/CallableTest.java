package com.ly.study.thinkjava.thread.executorTest;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class TaskWithResult implements Callable<String> {
	private int id;
	public TaskWithResult(int id) {
		this.id = id;
	}
	@Override
	public String call() {
		return "result of TaskWithResult " + id;
	}
}

public class CallableTest {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for (int i = 0; i < 5; ++i) {
			exec.submit(new TaskWithResult(i));			
		}
		for (Future<String> fs : results) {
			System.out.println(fs.get());
		}
	}

}
