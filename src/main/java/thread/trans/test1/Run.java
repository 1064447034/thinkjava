package thread.trans.test1;

public class Run {
	public static void main(String[] args) {
		Object obj = new Object();
		MyThread1 t1 = new MyThread1(obj);
		MyThread2 t2 = new MyThread2(obj);
		
		t1.start();
		t2.start();
		
	}
}
