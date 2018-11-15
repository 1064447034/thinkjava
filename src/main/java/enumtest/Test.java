package enumtest;

interface CanFlight {
	void flight();
}
interface CanSwim {
	void swim();
}
interface CanFly {
	void fly();
}
class ActionCharacter {
	public void flight() {
		System.out.println("ActionCharacter");
	}
}
class Hero extends ActionCharacter implements CanFlight, CanSwim, CanFly {
	public void flight() {
		System.out.println("hero");
	}
	@Override
	public void fly() {
		System.out.println("fly");
	}

	@Override
	public void swim() {
		System.out.println("swim");
	}
	
}
public class Test {
	public static void w(ActionCharacter ac) {
		ac.flight();
	}
	public static void main(String[] args) {
		Hero h = new Hero();
		w(h);
	}
}
