package com.ly.study.thinkjava.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortByKey {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("WNBA", "wnba");
		map.put("KFC", "kfc");
		map.put("NBA", "nba");
		map.put("CBA", "cba");
		map.put("123", "ccc");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());			
		}
		
		TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});

		treeMap.putAll(map);
		
		System.out.println();
		for (Map.Entry<String, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());			
		}

	}
}
