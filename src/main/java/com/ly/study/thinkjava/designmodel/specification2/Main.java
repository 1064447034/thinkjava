package com.ly.study.thinkjava.designmodel.specification2;

public class Main {
	public static void main(String[] args) {
		ISpecification2<Integer> event = new ISpecification2<Integer>() {
			 @Override
			public boolean IsSatisfiedBy(Integer candidate) {
				 return candidate.intValue() % 2 ==0;
			}
		};
		ISpecification2<Integer> plus = new ISpecification2<Integer>() {
			 @Override
			public boolean IsSatisfiedBy(Integer candidate) {
				 return candidate.intValue() > 0;
			}
		};
		
		ISpecification2<Integer> r = (x->x % 2 == 0);
		ISpecification2<Integer> r2 = (x->x > 0);
		System.out.println(r.And(r2).IsSatisfiedBy(10));
	}
	
}
