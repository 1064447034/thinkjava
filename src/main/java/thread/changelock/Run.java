package thread.changelock;

public class Run {
	public static void main(String[] args) {
		try {
			MyService service = new MyService();
			ThreadA a = new ThreadA(service);
			a.setName("A");
			ThreadB b = new ThreadB(service);
			b.setName("B");
			a.start();
//			Thread.sleep(50);
			b.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}