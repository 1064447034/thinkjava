package designpattern.visit.test3;

public class Lisi implements Visitor {
	@Override
	public void visit(Computer games) {
		games.doAction();
	}

}
