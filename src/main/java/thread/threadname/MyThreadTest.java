package thread.threadname;

public class MyThreadTest {
	public static void main(String[] args) {
        MyThread mt = new MyThread();
        Thread t = new Thread(mt);
        t.setName("A");
        t.start();
        mt.start();
    }
}
