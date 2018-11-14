package com.ly.study.thinkjava.algorithm;

public class TopN {
	private int parent(int n) {
		return (n - 1) / 2;
	}
	
	private int left(int n) {
		return 2 * n + 1;
	}
	
	private int right(int n) {
		return 2 * n + 2;
	}
	
}
