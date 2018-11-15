package thread.atomic;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class IntegerArray {
	public static void main(String[] args) {
		int[] value = new int[] {1, 2};
		AtomicIntegerArray ai = new AtomicIntegerArray(value);
		ai.getAndSet(0, 3);
		System.out.println(ai.get(0));
		System.out.println(Arrays.toString(value));
		
	}
}
