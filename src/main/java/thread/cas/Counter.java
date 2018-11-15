package thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger atomicI = new AtomicInteger(0);
	private int i = 0;
	public static void main(String[] args) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<>(600);
		long start = System.currentTimeMillis();
		for (int j = 0; j < 200; j++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; ++i) {
						cas.count();
						cas.safeCount();
					}
				}
			});
			ts.add(t);
		}
		for (Thread t : ts) {
			t.start();
		}
		for (Thread t : ts) {
			try {
				Thread.yield();
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(cas.i);
		System.out.println(cas.atomicI.get());
		System.out.println(System.currentTimeMillis() - start);
	}
	
	private void safeCount() {
		for (;;) {
			int i = atomicI.get();
			try {
			} catch (Exception e) {
				// TODO: handle exception
			}
			boolean suc = atomicI.compareAndSet(i, ++i);
			if (suc) {
				break;
			}
		}
	}
	
	private synchronized void count() {
		i++;
	}
	
}
