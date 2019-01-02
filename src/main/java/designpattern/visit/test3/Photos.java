package designpattern.visit.test3;

public class Photos implements Computer {
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public void doAction() {
		System.out.println("watch scenery photo");
	}
}
