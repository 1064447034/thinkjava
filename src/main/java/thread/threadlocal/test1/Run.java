package thread.threadlocal.test1;

public class Run {
	public static void main(String[] args) {
		try {
			ThreadA a = new ThreadA();
			ThreadB b = new ThreadB();
			a.start();
			b.start();
			
			for (int i = 0; i < 100; ++i) {
				Tools.tl.set("Main" +(i + 1));
				System.out.println("Main get value=" + Tools.tl.get());
				Thread.sleep(200);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
	