package thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	private static CountDownLatch countDownLatch = new CountDownLatch(2);
	
	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + "parse file1 success");
			}
		});
	
		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + "parse file2 success");
			}
		});
		
		parser1.start();
		parser2.start();
		countDownLatch.await();
		System.out.println("parsing txt files success");
	}
}
