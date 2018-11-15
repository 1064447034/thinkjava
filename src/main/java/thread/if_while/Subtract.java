package thread.if_while;

public class Subtract {
	private String lock;

	public Subtract(String lock) {
		super();
		this.lock = lock;
	}

	public void substract() {
		try {
			synchronized (lock) {
				while (ValueObject.list.size() == 0) {
					System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
					lock.wait(1000);
					System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
					System.out.println();
				}
				ValueObject.list.remove(0);
				System.out.println(Thread.currentThread().getName() + " list size=" + ValueObject.list.size());
				Thread.sleep(200);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
