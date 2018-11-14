package com.ly.study.thinkjava.designmodel.specification1;

public abstract class CompositeSpecification<T> implements ISpecification<T> {
	@Override
	public abstract boolean IsSatisfiedBy(T candidate);
	
	@Override
	public ISpecification<T> And(ISpecification<T> specification) {
		return new AndSpecification<T>(this, specification);
	} 
	
	@Override
	public ISpecification<T> Or(ISpecification<T> specification) {
		return new OrSpecification<T>(this, specification);
	}
	
	@Override
	public ISpecification<T> Not(ISpecification<T> specification) {
		return new NotSpecification<T>(specification);
	}
	
}
