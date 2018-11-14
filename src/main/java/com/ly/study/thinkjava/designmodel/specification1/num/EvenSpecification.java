package com.ly.study.thinkjava.designmodel.specification1.num;

import com.ly.study.thinkjava.designmodel.specification1.CompositeSpecification;

public class EvenSpecification extends CompositeSpecification<Integer> {
	@Override
	public boolean IsSatisfiedBy(Integer candidate) {
		return candidate.intValue() % 2 == 0;
	}
}
