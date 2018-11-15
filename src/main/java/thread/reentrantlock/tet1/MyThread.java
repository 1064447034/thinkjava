package thread.reentrantlock.tet1;

public class MyThread extends Thread {
	private MyService myService;
	public MyThread(MyService service) {
		this.myService = service;
	}
	@Override
	public void run() {
		super.run();
		myService.testMethod();
	}
}
