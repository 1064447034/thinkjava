package thread.reentrant.inherit;

public class Sub extends Main {
	synchronized public void operateISubMethod() {
		try {
			while (i > 0) {
				i--;
				System.out.println("sub print i=" + i);
				Thread.sleep(100);
				this.operateIMainMethod();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
