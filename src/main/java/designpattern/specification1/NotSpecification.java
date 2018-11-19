package designpattern.specification1;

public class NotSpecification<T> extends CompositeSpecification<T> {
	private ISpecification<T> specification;
	
	public NotSpecification(ISpecification<T> specification) {
		this.specification = specification;
	}
	
	@Override
	public boolean IsSatisfiedBy(T candidate) {
		return !specification.IsSatisfiedBy(candidate);
	}
	
}
