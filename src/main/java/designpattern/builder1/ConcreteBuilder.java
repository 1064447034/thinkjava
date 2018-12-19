package designpattern.builder1;

public class ConcreteBuilder implements Builder {
	private Product product = new Product();
	
	@Override
	public void buildPart1() {
		product.setName("name");
		System.out.println("buildPart1");
	}

	@Override
	public void buildPart2() {
		product.setType("type");
		System.out.println("buildPart2");
	}

	@Override
	public Product retrieveResult() {
		return product;
	}
	
}
