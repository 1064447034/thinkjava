package thread.if_while;

public class Run {
	public static void main(String[] args) throws InterruptedException {
		String lock = new String("");
		Add add = new Add(lock);
		Subtract subtract = new Subtract(lock);
		
		ThreadSubtract s1 = new ThreadSubtract(subtract);
		ThreadSubtract s2 = new ThreadSubtract(subtract);
		s1.setName("s1");
		s2.setName("s2");
		s1.start();
		s2.start();
		
		Thread.sleep(10000);
		
		ThreadAdd a = new ThreadAdd(add);
		a.setName("a");
		a.start();
	}
}
