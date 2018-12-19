package com.ly.study.thinkjava.thread.orderprint.inner_join;

public class T3 extends Thread{
    private Thread thread;
    public T3(Thread thread) {
        this.thread = thread;
    }
 
    @Override
	public void run(){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in T3");
    }

}
