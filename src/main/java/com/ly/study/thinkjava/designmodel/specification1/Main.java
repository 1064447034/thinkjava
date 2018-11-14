package com.ly.study.thinkjava.designmodel.specification1;

import com.ly.study.thinkjava.designmodel.specification1.num.EvenSpecification;
import com.ly.study.thinkjava.designmodel.specification1.num.PlusSpecification;

public class Main {
	public static void main(String[] args) {
		ISpecification<Integer> even = new EvenSpecification();
		ISpecification<Integer> plus = new PlusSpecification();
		
		ISpecification<Integer> r = even.And(plus);
		System.out.println(r.IsSatisfiedBy(2));
		System.out.println(r.IsSatisfiedBy(0));
		System.out.println(r.IsSatisfiedBy(-2));
	}

}
