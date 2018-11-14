package com.ly.study.thinkjava.thread.orderprint.inner_join;

import java.util.Random;

public class T1 extends Thread {
    @Override
	public void run(){
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in T1");
    }

}
