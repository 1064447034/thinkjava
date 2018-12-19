package com.ly.study.thinkjava.thread.wait.car;

public class Car {
	// Car有一个单一的布尔属性waxOn ，表示涂蜡•抛光处理的状态。
	// 初始是可以打蜡的状态
	private boolean waxOn = false;

	public synchronized void notifyBuffer() {
		waxOn = true; // Ready to buff 可以抛光
		notifyAll();
	}

	public synchronized void notifyWax() {
		waxOn = false; // Ready for another coat of wax 可以打蜡
		notifyAll();
	}

	// 等待打蜡 挂起抛光线程
	public synchronized void haltBuffer() throws InterruptedException {
		// 一直循环检查 只要是可以打蜡的状态就挂起抛光的线程
		while (waxOn == false)
			wait();
	}

	// 等待抛光 挂起打蜡线程
	public synchronized void haltWax() throws InterruptedException {
		// 一直循环检查 只要是可以抛光的状态就挂起打蜡的线程
		while (waxOn == true)
			wait();
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
				car.notifyBuffer();
				// 挂起打蜡的线程
				car.haltWax();
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
				car.haltBuffer();
				// 模拟抛光 非阻塞耗时任务
				System.out.println("wax off");
				// waxOn时获取 将其变为waxOff 之后notifyAll
				car.notifyWax();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Wax off via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}