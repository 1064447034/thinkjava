package thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CycliBarrierTest2 {
	static CyclicBarrier c = new CyclicBarrier(2, new A());
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					c.await();
				} catch (Exception e) {
				}
				System.out.println(1);
			}
		}).start();
		try {
			c.await();
		} catch (Exception e) {
		}
		System.out.println(2);
	}
	
	static class A implements Runnable {
		@Override
		public void run() {
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(3);
		}
	}
}
