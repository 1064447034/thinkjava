package thread.volatiletest.test2;

public class MyThread extends Thread {
	public volatile static int count;

	private synchronized static void addCount() {
		for (int i = 0; i < 100; ++i) {
			count++;
		}
		System.out.println("count=" + count);
	}

	@Override
	public void run() {
		super.run();
		addCount();
	}
}
