package designpattern.singleton.enumtest;

public class MyThread extends Thread {
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 5; ++i) {
			System.out.println(MyObject.connectionFactory.getConnection().hashCode());
		}
	}
}
