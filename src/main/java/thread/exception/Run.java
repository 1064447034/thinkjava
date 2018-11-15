package thread.exception;

public class Run {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		thread.start();
		
		for (int i = 0; i < 100; ++i) {
			System.out.println(i);
			try {
				Thread.sleep(1000);				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
