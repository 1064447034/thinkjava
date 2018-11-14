package com.ly.study.thinkjava.java8future;

import java.util.Arrays;

interface Inter {
	public int func();
}

@FunctionalInterface
interface FI {
	abstract void judge(int a);
	@Override
	abstract boolean equals(Object obj);   
}

public class Lambda {
	public static void main(String[] args) {
		String[] players = {"Rafael Nadal", "Novak Djokovic",   
			    "Stanislas Wawrinka", "David Ferrer",  
			    "Roger Federer", "Andy Murray",  
			    "Tomas Berdych", "Juan Martin Del Potro",  
			    "Richard Gasquet", "John Isner"};  
		Arrays.sort(players, (s1, s2)->s1.compareTo(s2));
		System.out.println(Arrays.toString(players));
		
		int i[] = {3, 5};
		
	}
}
