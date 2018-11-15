package thread.test1;

public class MyThread extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; ++i) {
				int time = (int)(Math.random() * 2000);
				Thread.sleep(time);
				System.out.println("run=" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
