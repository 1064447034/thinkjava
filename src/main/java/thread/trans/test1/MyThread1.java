package thread.trans.test1;

public class MyThread1 extends Thread {
	private Object object;
	public MyThread1(Object obj) {
		this.object = obj;
	}
	
	@Override
	public void run() {
		try {
			synchronized(object) {
				System.out.println("begin ");
				object.wait();
				System.out.println("end ");
			}
		} catch (Exception e) {
			
		}
	}
}
