package designpattern.visit.test3;

public class ZhangSan implements Visitor {
	@Override
	public void visit(Computer games) {
		games.doAction();
	}

}
