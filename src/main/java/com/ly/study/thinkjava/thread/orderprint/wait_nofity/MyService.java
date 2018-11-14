package com.ly.study.thinkjava.thread.orderprint.wait_nofity;

public class MyService {
    private volatile int orderNum = 1;
 
    public synchronized void methodA() {
        try {
            while (orderNum != 1) {
                wait();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " " + "AAAAA");
            }
            orderNum = 2;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public synchronized void methodB() {
        try {
            while (orderNum != 2) {
                wait();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " " + "BBBBB");
            }
            orderNum = 3;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    public synchronized void methodC() {
        try {
            while (orderNum != 3) {
                wait();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName() + " " + "CCCCC");
            }
            orderNum = 1;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
