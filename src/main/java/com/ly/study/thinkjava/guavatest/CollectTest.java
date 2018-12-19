package com.ly.study.thinkjava.guavatest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class CollectTest {
	public static void main(String[] args) {
		CollectTest tester = new CollectTest();
		Multimap<String, String> multimap = tester.getMultimap();
		List<String> lowerList = (List<String>)multimap.get("lower");
		System.out.println(lowerList.toString());
		
		lowerList.add("f");
		System.out.println(lowerList.toString());
		
		Map<String, Collection<String>> map = multimap.asMap();
		for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			Collection<String> value = multimap.get("lower");
			System.out.println("key: " + key + "value: " + value);
		}
	}
	
	private Multimap<String, String> getMultimap() {
		Multimap<String, String> multimap = ArrayListMultimap.create();
		
		multimap.put("lower", "a");
	    multimap.put("lower", "b");
	    multimap.put("lower", "c");
	    multimap.put("lower", "d");
	    multimap.put("lower", "e");
	    
	    multimap.put("upper", "A");
	    multimap.put("upper", "B");
	    multimap.put("upper", "C");
	    multimap.put("upper", "D");	
	 
	    return multimap; 
	}
}
