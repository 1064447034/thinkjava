package com.ly.study.thinkjava.enumtest;

enum Likeclasses {
	WINKEN {
		@Override
		void behavior() {
			System.out.println("behavior");
		}
	}, 
	BLIKNEN {
		@Override
		void behavior() {
			System.out.println("bliken");
		}
	};
	abstract void behavior();
}

public class NotClasses {
	void func(Likeclasses lcs) {
		lcs.behavior();
	}
}
