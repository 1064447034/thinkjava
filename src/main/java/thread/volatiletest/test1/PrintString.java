package thread.volatiletest.test1;

public class PrintString implements Runnable {
	private  boolean isContinuePrint = true;

	public boolean isContinuePrint() {
		return isContinuePrint;
	}
	
	public void setContinuePrint(boolean isContinuePrint) {
		this.isContinuePrint = isContinuePrint;
	}

	public void printStringMethod() {
		try {
			while (isContinuePrint) {
				System.out.println("run printStringMethod threadname=" + Thread.currentThread().getName());
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		printStringMethod();		
	}
}
