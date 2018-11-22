package com.ly.study.thinkjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class CharacterTest {
	static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(tableSizeFor(1));
		System.out.println(tableSizeFor(5));
		System.out.println(tableSizeFor(16));
		
	}
}
