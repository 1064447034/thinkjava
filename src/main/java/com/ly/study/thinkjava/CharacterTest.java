package com.ly.study.thinkjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Jon {
	private String air;

	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}
	
}
public class CharacterTest {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(132,3, 5, 23);
		Integer r = Collections.min(lst, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		System.out.println(r);
		
		System.out.println(Integer.toBinaryString(10 >>> 2));
	}
}
