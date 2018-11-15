package thread.reentrant.inherit;

public class MyThread extends Thread {
	@Override
	public void run() {
		Sub sub = new Sub();
		sub.operateISubMethod();
	}
}
