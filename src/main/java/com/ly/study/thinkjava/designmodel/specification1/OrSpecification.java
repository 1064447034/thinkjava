package com.ly.study.thinkjava.designmodel.specification1;

public class OrSpecification<T> extends CompositeSpecification<T> {
	private ISpecification<T> leftSpecification;
	private ISpecification<T> rightSpecification;
	
	public OrSpecification(ISpecification<T> left, ISpecification<T> right) {
		this.leftSpecification = left;
		this.rightSpecification = right;
	}
	
	@Override
	public boolean IsSatisfiedBy(T candidate) {
		return leftSpecification.IsSatisfiedBy(candidate) || rightSpecification.IsSatisfiedBy(candidate);
	}

}
