package thread.productor_consumer.one_one;

public class ThreadP extends Thread {
	private P p;
	
	public ThreadP(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			p.setValue();
		}
	}
}
