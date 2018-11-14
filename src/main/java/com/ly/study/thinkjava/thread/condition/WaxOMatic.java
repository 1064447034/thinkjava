package com.ly.study.thinkjava.thread.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        //这两个线程都有可能先启动执行
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
//        TimeUnit.MILLISECONDS.sleep(1200); // Run for a while...
        TimeUnit.SECONDS.sleep(10);
        //此时 对于WaxOn Thread 由于其线程挂起，那么直接catch InterruptedException
        //对于WaxOff Thread，其正在执行非阻塞的数学计算 此时interrupt，
        //首先循环将结束，然后循环会经由while语句的顶部退出
        //使用了耗时任务来模拟
        exec.shutdownNow(); // Interrupt all tasks
        
    }
}