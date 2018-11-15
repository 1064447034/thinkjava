package thread.trans.turn;

public class DBTools {
	private volatile boolean prevIsA = false;
	public synchronized void backupA() {
		try {
			while (prevIsA) {
				wait();
			}
			for (int i = 0; i < 1; ++i) {
				System.out.println("*****");
			}
			prevIsA = true;
			notifyAll();
		} catch (Exception e) {

		}
	}
	
	public synchronized void backupB() {
		try {
			while (!prevIsA) {
				wait();
			}
			for (int i = 0; i < 1; ++i) {
				System.out.println("=======");
			}
			prevIsA = false;
			notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
