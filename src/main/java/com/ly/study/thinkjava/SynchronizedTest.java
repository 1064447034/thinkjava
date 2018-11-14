package com.ly.study.thinkjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class Thread1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 5; ++i) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

public class SynchronizedTest {
	public static void main(String[] args) {
//		List<String> lst = Arrays.asList("1111", "2222", "3333", "4444");
		List<String> lst = new ArrayList<>(Arrays.asList("1111", "2222", "3333", "4444"));
		
		List<String> lst2 = lst;
		System.out.println(lst);
		System.out.println(lst2);
		
//		for (ListIterator<String> iter = lst.listIterator(); iter.hasNext(); ) {
//			iter.remove();
//		}
		ListIterator<String> iter = lst.listIterator(); 
		while (iter.hasNext()) {
			iter.next();
			iter.remove();
		}
		System.out.println(lst);
		System.out.println(lst2);
		
	}
}
