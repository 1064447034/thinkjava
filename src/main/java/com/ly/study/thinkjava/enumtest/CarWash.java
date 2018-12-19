package com.ly.study.thinkjava.enumtest;

import java.util.EnumSet;

public class CarWash {
	public enum Cycle {
		UNDERBODY {
			@Override
			void action() {
				System.out.println("Spraying the undebody");
			}
		},
		WHEELWASH {
			@Override
			void action() {
				System.out.println("Washing the wheels");
			}
		},
		PREWASH {
			@Override
			void action() {
				System.out.println("prewash");
			}
		},
		BASIC {
			@Override
			void action() {
				System.out.println("basic");
			}
		};
		abstract void action();
	}
	EnumSet<Cycle> cycles = EnumSet.of(Cycle.UNDERBODY, Cycle.WHEELWASH);
	public void add(Cycle cycle) {
		cycles.add(cycle);
	}
	
	public void washCar() {
		for (Cycle c : cycles) {
			c.action();
		}
	}
	
	@Override
	public String toString() {
		return cycles.toString();
	}
	
	public static void main(String[] args) {
		CarWash wash = new CarWash();
		System.out.println(wash);
		wash.washCar();
		wash.add(Cycle.WHEELWASH);
		wash.washCar();
		
	}
}
