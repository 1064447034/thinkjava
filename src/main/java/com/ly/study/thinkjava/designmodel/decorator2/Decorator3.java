package com.ly.study.thinkjava.designmodel.decorator2;

abstract class XHuman {
	public abstract void wearClothes();
	public abstract void walkToWhere();
}

abstract class XDecorator extends XHuman {
	@Override
	public abstract void wearClothes();
	@Override
	public abstract void walkToWhere();
}

class XDecorator_zero extends XDecorator {
	private XHuman human;
	public XDecorator_zero(XHuman human) {
		this.human = human;
	}

	public void goHome() {
		System.out.println("进房子。。");
	}

	public void findMap() {
		System.out.println("书房找找Map。。");
	}

	@Override
	public void wearClothes() {
		human.wearClothes();
		goHome();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		human.walkToWhere();
		findMap();
	}
}

class XDecorator_first extends XDecorator {
	private XHuman human;
	public XDecorator_first(XHuman human) {
		this.human = human;
	}

	public void goClothespress() {
		System.out.println("去衣柜找找看。。");
	}

	public void findPlaceOnMap() {
		System.out.println("在Map上找找。。");
	}

	@Override
	public void wearClothes() {
		human.wearClothes();
		goClothespress();
	}

	@Override
	public void walkToWhere() {
		human.walkToWhere();
		findPlaceOnMap();
	}
}

class XDecorator_two extends XDecorator {
	private XHuman human;
	public XDecorator_two(XHuman human) {
		this.human = human;
	}

	public void findClothes() {
		System.out.println("找到一件D&G。。");
	}

	public void findTheTarget() {
		System.out.println("在Map上找到神秘花园和城堡。。");
	}

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		human.wearClothes();
		findClothes();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		human.walkToWhere();
		findTheTarget();
	}
}

class XPerson extends XHuman {
	@Override
	public void wearClothes() {
		System.out.println("穿什么呢。。");
	}

	@Override
	public void walkToWhere() {
		System.out.println("去哪里呢。。");
	}
}

public class Decorator3 {
	public static void main(String[] args) {
		XHuman person = new XPerson();
		XDecorator decorator = new XDecorator_two(new XDecorator_first(new XDecorator_zero(person)));
		decorator.wearClothes();
//		decorator.walkToWhere();
	}
}
