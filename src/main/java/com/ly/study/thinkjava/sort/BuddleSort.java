package com.ly.study.thinkjava.sort;

import java.util.Arrays;

public class BuddleSort {
	public static void main(String[] args) {
		int[] array = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array.length - i - 1; ++j) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
}
