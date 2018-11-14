package com.ly.study.thinkjava;

import static com.ly.study.thinkjava.Input.ABORT_TRANSACTION;
import static com.ly.study.thinkjava.Input.CHIPS;
import static com.ly.study.thinkjava.Input.DIME;
import static com.ly.study.thinkjava.Input.DOLLAR;
import static com.ly.study.thinkjava.Input.NICKL;
import static com.ly.study.thinkjava.Input.QUARTER;
import static com.ly.study.thinkjava.Input.SOAP;
import static com.ly.study.thinkjava.Input.SODA;
import static com.ly.study.thinkjava.Input.STOP;
import static com.ly.study.thinkjava.Input.TOOTHPASTE;

import java.util.EnumMap;
import java.util.Random;

public class EnumTest {
	public static void main(String[] args) {
		
	}
}

enum Input {
	NICKL(5), DIME(10), QUARTER(25), DOLLAR(100),
	TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
	ABORT_TRANSACTION {
		@Override
		public int amount() {
			throw new RuntimeException("ABORT.amount()");
		}
	},
	STOP {
		@Override
		public int amount() {
			throw new RuntimeException("SHUT_DOWN.amount()");
		}
	};
	int value;
	Input() {
		System.out.println("enum");
	}
	Input(int value) {
		this.value = value;
	}
	int amount() {
		return value;
	}
	static Random rand = new Random(47);
	public static Input randomSelect() {
		return values()[rand.nextInt(values().length)];
	}
}

enum Category {
	MONEY(NICKL, DIME, QUARTER, DOLLAR),
	ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
	QUIT_TRANSACTION(ABORT_TRANSACTION),
	SHUT_DOWN(STOP);
	
	private Input[] values;
	Category(Input...types) {
		this.values = types;
	}
	
	private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(Input.class);
	static {
		for (Category c : Category.class.getEnumConstants()) {
			for (Input type : c.values) {
				categories.put(type, c);
			}
		}
	}
	public static Category categorize(Input input) {
		return categories.get(input);
	}
}
