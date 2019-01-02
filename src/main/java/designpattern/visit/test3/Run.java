package designpattern.visit.test3;

public class Run {
	public static void main(String[] args) {
		Computer games = new Games();
		Computer photos = new Photos();
		Visitor visitor = new ZhangSan();
		games.accept(visitor);
		photos.accept(visitor);
		
		Visitor lisi = new Lisi();
		games.accept(lisi);
	}
}
