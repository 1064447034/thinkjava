package com.ly.study.thinkjava.guavatest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class CollectTest2 {
	public static void main(String[] args) {
		// test1
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list);
		
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println(unmodifiableList);
		
		list.add("addOnList");
		
		System.out.println(list);
		System.out.println(unmodifiableList);
		
		System.out.println("--------------------------------------------");
		// test2
		List<String> lst = new ArrayList<String>() {
			{
				add("a");
				add("b");
				add("c");
			}
		};
		ImmutableList<String> imList = ImmutableList.<String>copyOf(lst);
		System.out.println(imList);
		
		ImmutableList<String> imOfList = ImmutableList.of("peida", "jerry", "harry");
		System.out.println(imOfList);
		
		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		System.out.println("imSortList: " + imSortList);
		
		lst.add("babby");
		
		System.out.println(lst);
		System.out.println(imList);
		
		ImmutableSet<Color> imColor = ImmutableSet.<Color>builder()
				.add(new Color(0, 255, 255))
				.add(new Color(0, 191, 255))
				.build();
		
		Cache<Integer, String> cache = CacheBuilder.newBuilder()
				.initialCapacity(10)
				.concurrencyLevel(5)
				.expireAfterWrite(10, TimeUnit.SECONDS)
				.build();
		cache.put(1, "Hi!");
		System.out.println(cache.getIfPresent(1));
		
		
	}
	
}

class Color {
	private int red;
	private int green;
	private int blue;
	
	public Color(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public int getBlue() {
		return blue;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	
}



