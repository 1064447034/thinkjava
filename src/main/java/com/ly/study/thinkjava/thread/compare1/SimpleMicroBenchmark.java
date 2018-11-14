package com.ly.study.thinkjava.thread.compare1;

public class SimpleMicroBenchmark {
	static long test(Incrementable incr) {
		long start = System.nanoTime();
		for (long i = 0; i < 10000000L; ++i) {
			incr.increment();
		}
		return System.nanoTime() - start;
	}
	public static void main(String[] args) {
		long synchTime = test(new SynchronizingTest());
		long lockTime = test(new LockingTest());
		System.out.printf("synchronized: %10d\n", synchTime);
		System.out.printf("Lock: %10d", lockTime);
		
	}
}
