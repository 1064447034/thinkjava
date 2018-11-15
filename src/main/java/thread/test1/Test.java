package thread.test1;

public class Test {
	public static void main(String[] args) {
		new Runnable() {
			@Override
			public void run() {
				System.out.println();
			}
		};
		
		try {
			MyThread thread = new MyThread();
			thread.setName("myThread");
			thread.run();
//			thread.start();
			
			for (int i = 0; i < 10; ++i) {
				int time = (int)(Math.random() * 2000);
				Thread.sleep(time);
				System.out.println("main=" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
