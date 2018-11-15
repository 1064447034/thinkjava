package thread.test3;

public class HasSelfPrivateNum {
	int num = 0;

	public synchronized void addI(String username) {
		try {
			if (username.equals("a")) {
				num = 100;
				System.out.println("a set over");
				Thread.sleep(2000);
			} else if (username.equals("b")) {
				num = 200;
				System.out.println("b set over");
				Thread.sleep(2000);
			}
			System.out.println(username + " num=" + num);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
