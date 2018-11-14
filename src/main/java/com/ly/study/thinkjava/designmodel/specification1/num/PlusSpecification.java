package com.ly.study.thinkjava.designmodel.specification1.num;

import com.ly.study.thinkjava.designmodel.specification1.CompositeSpecification;

public class PlusSpecification extends CompositeSpecification<Integer> {
	@Override
	public boolean IsSatisfiedBy(Integer candidate) {
		return candidate.intValue() > 0;
	}
}
