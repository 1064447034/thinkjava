package thread.productor_consumer.product_consum;

public interface Model {
	Runnable newRunnableConsumer();
	Runnable newRunnableProducer();
	
}
