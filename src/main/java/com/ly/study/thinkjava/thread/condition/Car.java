package com.ly.study.thinkjava.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car {
	// Car有一个单一的布尔属性waxOn ，表示涂蜡•抛光处理的状态。
	// 初始是可以打蜡的状态
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;

	public void waxed() {
		lock.lock();
		try {
			waxOn = true; // Ready to buff 可以抛光
			condition.signalAll();			
		} finally {
			lock.unlock();
		}
	}

	public  void buffed() {
		lock.lock();
		try {
			waxOn = false; // Ready for another coat of wax 可以打蜡
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	// 等待打蜡 挂起抛光线程
	public  void waitForWaxing() throws InterruptedException {
		// 一直循环检查 只要是可以打蜡的状态就挂起抛光的线程
		lock.lock();
		try {
			while (waxOn == false)
				condition.await();
		} finally {
			lock.unlock();
		}
	}

	// 等待抛光 挂起打蜡线程
	public  void waitForBuffing() throws InterruptedException {
		// 一直循环检查 只要是可以抛光的状态就挂起打蜡的线程
		lock.lock();
		try {
			while (waxOn == true)
				condition.await();
		} finally {
			lock.unlock();
		}
	}
}

// 打蜡
class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car c) {
		car = c;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				// 模拟打蜡 非阻塞
				System.out.println("Wax On! ");
				// 将waxOn = true 之后通知抛光线程
				car.waxed();
				// 挂起打蜡的线程
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Wax on via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
}

// 抛光
class WaxOff implements Runnable {
	private Car car;

	public WaxOff(Car c) {
		car = c;
	}

	@Override
	public void run() {
		try {
			// 使用了中断的惯用法
			while (!Thread.interrupted()) {
				// 初始是可以打蜡的状态
				// 只要是可以打蜡状态 就将抛光线程挂起
				// 初始waxOn=off 挂起抛光线程
				car.waitForWaxing();
				// 模拟抛光 非阻塞耗时任务
				System.out.println("wax off");
				// waxOn时获取 将其变为waxOff 之后notifyAll
				car.buffed();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Wax off via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}