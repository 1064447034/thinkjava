package com.ly.study.thinkjava.thread.scheduled;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "day";
	public synchronized String getThermostat() {
		return thermostat;
	}
	public synchronized void setThermostat(String thermostat) {
		this.thermostat = thermostat;
	}
	
	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
	public void schedule(Runnable event, long delay) {
		scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
	}
	
	public void repeat(Runnable event, long initialDelay, long period) {
		scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
	}
	
	class LightOn implements Runnable {
		@Override
		public void run() {
			System.out.println("turning on lights");
			light = true;
		}
	}
	
	class LightOff implements Runnable {
		@Override
		public void run() {
			System.out.println("turning off lights");
			light = false;
		}
	}
}
