package thread.trans.test1;

public class MyThread2 extends Thread {
	private Object obj;
	
	public MyThread2(Object obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		synchronized(obj) {
			System.out.println("begin2 ");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			obj.notify();
			System.out.println("end2");
		}
	}
}
