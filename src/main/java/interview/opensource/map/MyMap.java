package interview.opensource.map;

public interface MyMap<K, V> {

	int size();

	interface Entry<K, V> {
		K getKey();
	}

	boolean isEmpty();
//	default boolean isEmpty() {
//		return true;
//	}

}
