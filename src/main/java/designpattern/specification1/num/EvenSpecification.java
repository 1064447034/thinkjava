package designpattern.specification1.num;

import designpattern.specification1.CompositeSpecification;

public class EvenSpecification extends CompositeSpecification<Integer> {
	@Override
	public boolean IsSatisfiedBy(Integer candidate) {
		return candidate.intValue() % 2 == 0;
	}
}
