package thread.if_while;

public class ThreadSubtract extends Thread {
	private Subtract r;

	public ThreadSubtract(Subtract r) {
		super();
		this.r = r;
	}
	
	@Override
	public void run() {
		r.substract();
	}
}
