package thread.exception;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		String username = null;
		System.out.println(username.hashCode());
	}
}
