package thread.productor_consumer.many_many_bug;

import thread.productor_consumer.one_one.ValueObject;

public class P {
	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}
	public void setValue() {
		try {
			synchronized(lock) {
				while (!ValueObject.value.equals("")) {
					System.out.println("生产者 " + Thread.currentThread().getName() + " waiting了*");
					lock.wait();
				}
				System.out.println("生产者 " + Thread.currentThread().getName() + " running了");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.value = value;
				lock.notify();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
