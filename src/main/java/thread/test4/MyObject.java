package thread.test4;

public class MyObject {
	public synchronized void methodA() {
		try {
			System.out.println("begin methodA threadname=" + Thread.currentThread().getName());
			Thread.sleep(3000);
			System.out.println("end A");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public synchronized void methodB() {
		try {
			System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end B");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
