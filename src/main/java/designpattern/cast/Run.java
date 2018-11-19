package designpattern.cast;

public class Run {
	public static void main(String[] args) {
		Horse h = new BlackHorse();
		WhiteHorse w = (WhiteHorse)h;
		w.sys();
	}
}
