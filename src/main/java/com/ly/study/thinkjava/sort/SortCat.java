package com.ly.study.thinkjava.sort;

import com.alibaba.fastjson.JSON;

public class SortCat {
	public static void main(String[] args) {
		Cat c0 = new Cat("灰猫", "china");
		Cat c1 = new Cat("黑猫","china");
		Cat c2 = new Cat("黑猫", "china");
		Cat c3 = new Cat("白猫", "china");
		Cat c11 = new Cat("黄猫", "china");
		Cat c13 = new Cat("黄猫", "china");
		Cat c4 = new Cat("白猫", "china");
		Cat c5 = new Cat("灰猫", "china");
		Cat c12 = new Cat("黄猫", "china");
		Cat c6 = new Cat("白猫", "china");
		Cat c7 = new Cat("灰猫", "china");
		Cat c8 = new Cat("黑猫", "china");
		Cat c14 = new Cat("黄猫", "china");
		Cat c9 = new Cat("黑猫", "china");
		Cat c10 = new Cat("白猫", "china");
		Cat c15 = new Cat("灰猫", "china");
		Cat c16 = new Cat("灰猫", "china");
		Cat c17 = new Cat("黄猫", "china");
		
		Cat[] cats = new Cat[]{c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17};
		for (int i = 0; i < cats.length; ++i) {
			for (int j = 0; j < cats.length - i - 1; ++j) {
				if (cats[j].getColor().equals("白猫") && (!cats[j + 1].getColor().equals("白猫"))) {
					Cat temp = cats[j];
					cats[j] = cats[j + 1];
					cats[j + 1] = temp;
				}
			}

			for (int m = 0; m < cats.length - i - 1; ++m) {
				if (cats[m].getColor().equals("灰猫") && !cats[m + 1].getColor().equals("灰猫")) {
					Cat temp = cats[m];
					cats[m] = cats[m + 1];
					cats[m + 1] = temp;
				}
			}
			for (int m = 0; m < cats.length - i - 1; ++m) {
				if (cats[m].getColor().equals("黑猫") && !cats[m + 1].getColor().equals("黑猫")) {
					Cat temp = cats[m];
					cats[m] = cats[m + 1];
					cats[m + 1] = temp;
				}
			}

		}
		for (int k = 0; k < cats.length; ++k) {
			System.out.println(JSON.toJSONString(cats[k]));
		}
	}
}
