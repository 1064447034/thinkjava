package designpattern.specification1;

public interface ISpecification<T> {
	boolean IsSatisfiedBy(T candidate);
	ISpecification<T> And(ISpecification<T> specification);
	ISpecification<T> Or(ISpecification<T> specification);
	ISpecification<T> Not(ISpecification<T> specification);
	
}
