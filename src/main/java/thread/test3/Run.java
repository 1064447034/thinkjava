package thread.test3;

public class Run {
	public static void main(String[] args) {
		HasSelfPrivateNum numRef = new HasSelfPrivateNum();
		ThreadA threada = new ThreadA(numRef);
		ThreadB threadb = new ThreadB(numRef);
		
		threada.start();
		threadb.start();
	}
}
