package enumtest;

import java.util.Random;

interface Generator<T> {
	public T next();
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
	SLAPP,
	SPANKY,
	PUNCHY,
	SILLY,
	BOUNCY,
	NUTTY,
	BOB;
	private Random rand = new Random(47);
	
	@Override
	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
	
}

public class EnumImplementation {
	public static <T> T printNext(Generator<T> g) {
		return g.next();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			printNext(CartoonCharacter.SLAPP);
		}
	}
}
