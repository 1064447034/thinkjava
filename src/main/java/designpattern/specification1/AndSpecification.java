package designpattern.specification1;

public class AndSpecification<T> extends CompositeSpecification<T> {
	private ISpecification<T> leftSpecification;
	private ISpecification<T> rightSpecification;
	
	public AndSpecification(ISpecification<T> left, ISpecification<T> right) {
		this.leftSpecification = left;
		this.rightSpecification = right;
	}
	
	@Override
	public boolean IsSatisfiedBy(T candidate) {
		return this.leftSpecification.IsSatisfiedBy(candidate) && this.rightSpecification.IsSatisfiedBy(candidate);
	}

}
