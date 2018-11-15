package thread.threadlocal.test1;

public class ThreadB extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 100; ++i) {
				Tools.tl.set("ThreadB" + (i + 1));
				System.out.println("ThreadB get value=" + Tools.tl.get());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
