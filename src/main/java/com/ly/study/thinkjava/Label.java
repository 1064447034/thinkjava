package com.ly.study.thinkjava;

public class Label {
	public static void main(String[] args) {
		testContinue();
	}

	public static void testBreak() {
		for (int m = 0; m < 3; ++m) {
			Outer: for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					if (j == 3) {
						break Outer;
					}
					System.out.println("i = " + i + " j =" + j);
				}
			}
			System.out.println("exit!");
		}
	}

	public static void testContinue() {
		for (int m = 0; m < 3; ++m) {
			Outer: for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					if (j == 3) {
						continue ;
					}
					System.out.println("i = " + i + " j =" + j);
				}
			}
			System.out.println("exit!");
		}
	}
}
