package designpattern.specification1.num;

import designpattern.specification1.CompositeSpecification;

public class PlusSpecification extends CompositeSpecification<Integer> {
	@Override
	public boolean IsSatisfiedBy(Integer candidate) {
		return candidate.intValue() > 0;
	}
}
