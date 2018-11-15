package thread.test4;

public class Run {
	public static void main(String[] args) {
		MyObject obj = new MyObject();
		ThreadA a = new ThreadA(obj);
		a.setName("A");
		ThreadB b = new ThreadB(obj);
		b.setName("B");
		a.start();
		b.start();
		
	}
}
