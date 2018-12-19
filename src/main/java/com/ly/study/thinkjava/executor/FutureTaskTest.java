package com.ly.study.thinkjava.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
	public static void main(String[] args) {
//		ExecutorService executor = Executors.newCachedThreadPool();
//		Task task = new Task();
//		FutureTask<Integer> futureTask = new FutureTask<>(task);
//		executor.submit(task);
//		executor.shutdown();
		
		Task2 task = new Task2();
		FutureTask<Integer> futureTask = new FutureTask<>(task);
		Thread thread = new Thread(futureTask);
		thread.start();
		
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
        System.out.println("主线程在执行任务");
         
        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
         
        System.out.println("所有任务执行完毕");
	}
}

class Task2 implements Callable<Integer> {
	@Override
	public Integer call() throws InterruptedException {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += i;
		return sum;
	}
}