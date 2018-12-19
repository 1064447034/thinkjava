package designpattern.state.test1;

public class Run {
	public static void main(String[] args) {
		Switcher s = new Switcher();
		s.switchOff();
		s.switchOn();
		s.switchOn();
		s.switchOff();
		s.switchOff();
	}
}	
