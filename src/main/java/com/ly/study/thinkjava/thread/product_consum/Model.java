package com.ly.study.thinkjava.thread.product_consum;

public interface Model {
	Runnable newRunnableConsumer();
	Runnable newRunnableProducer();
	
}
