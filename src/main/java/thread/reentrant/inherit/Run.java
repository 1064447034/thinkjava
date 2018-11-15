package thread.reentrant.inherit;

public class Run {
	public static void main(String[] args) {
		String a = "A";
		String b = "A";
		System.out.println(a == b);
		MyThread t = new MyThread();
		t.start();
	}
}
