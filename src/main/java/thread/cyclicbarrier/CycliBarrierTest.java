package thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CycliBarrierTest {
	static CyclicBarrier c = new CyclicBarrier(2);
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					c.await();
				} catch (Exception e) {
				}
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
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
}
