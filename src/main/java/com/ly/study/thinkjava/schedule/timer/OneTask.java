package com.ly.study.thinkjava.schedule.timer;

import java.util.Timer;
import java.util.TimerTask;

public class OneTask extends TimerTask {
	private Timer timer;
    private int id;
    public OneTask(Timer timer, int id){ 
        this.timer = timer;
    	this.id = id;
    }
      
    @Override
    public void run() { 
        System.out.println("线程"+ id +":  正在 执行。。");  
        //System.gc();
        timer.cancel();
    }    
	}
