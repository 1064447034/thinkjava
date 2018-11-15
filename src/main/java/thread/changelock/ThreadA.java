package thread.changelock;

public class ThreadA extends Thread {
	private MyService service;
	public ThreadA(MyService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; ++i) {
			service.testMethod();			
		}
	}
}
