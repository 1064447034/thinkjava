package thread.productor_consumer.many_many_bug;

public class C {
	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}
	public void getValue() {
		try {
			synchronized(lock) {
				while (ValueObject.value.equals("")) {
					System.out.println("消费者 " + Thread.currentThread().getName() + " waiting#");
					lock.wait();
				}
				System.out.println("消费者 " + Thread.currentThread().getName() + " runnable了");
				ValueObject.value = "";
				lock.notify();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
