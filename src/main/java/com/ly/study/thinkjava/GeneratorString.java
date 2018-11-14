package com.ly.study.thinkjava;

import java.util.Random;

public class GeneratorString {
	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i) {
			System.out.println(produce(44));
		}
	}

	public static String produceStringAndNumber(int maxLength) {
		String source = "abcdefghijklmnopqrstuvwxyz0123456789";
		return doProduce(maxLength, source);
	}

	public static String doProduce(int maxLength, String source) {
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < maxLength; i++) {
			final int number = produceNumber(source.length());
			sb.append(source.charAt(number));
		}
		return sb.toString();
	}

	public static final int produceNumber(int maxLength) {
		Random random = new Random();
		return random.nextInt(maxLength);
	}
	
	public static String produce(int maxLength) {
		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer(100);
		for (int i = 0; i < maxLength; i++) {
			Random random = new Random();
			final int number = random.nextInt(source.length());
			sb.append(source.charAt(number));
		}
		return sb.toString();
	}
}
