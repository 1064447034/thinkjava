package com.ly.study.thinkjava.schedule.timer;

import java.util.Timer;

public class Test1 {
	public static void main(String[] args) throws Exception {
		Timer timer = new Timer(); 
		timer.schedule(new OneTask(timer, 1), 2000);// 5秒后启动任务
		Thread.sleep(2000);
//		timer.cancel();
	}
}
