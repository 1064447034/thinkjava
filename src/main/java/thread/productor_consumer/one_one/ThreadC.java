package thread.productor_consumer.one_one;

public class ThreadC extends Thread {
	private C c;

	public ThreadC(C c) {
		super();
		this.c = c;
	}
	
	@Override
	public void run() {
		while (true) {
			c.getValue();	
		}
	}
}
