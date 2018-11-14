package com.ly.study.thinkjava.reverse;

public class Run {
	public static void main(String[] args) {
		String str = "ABC DEF 1234";	// DEF ABC
		String[] words = str.split(" ");
		String out = "";
		for (int j = words.length - 1; j >=0; --j) {
			out += words[j] + " ";
		}
		System.out.println(out);
	}
}
