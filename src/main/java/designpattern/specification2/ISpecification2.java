package designpattern.specification2;

@FunctionalInterface
public interface ISpecification2<T> {
	boolean IsSatisfiedBy(T candidate);
	
	default ISpecification2<T> And(ISpecification2<? super T> specification) {
		return (t) -> IsSatisfiedBy(t) && specification.IsSatisfiedBy(t);
	}
	
	default ISpecification2<T> Or(ISpecification2<? super T> specification) {
		return t->IsSatisfiedBy(t) || specification.IsSatisfiedBy(t);
	}
	
	default ISpecification2<T> Not() {
		return (t)->!IsSatisfiedBy(t);
	}
	
}
