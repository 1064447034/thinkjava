package com.ly.study.thinkjava.guavatest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner.MapJoiner;

public class JoinerTest {
	public static void main(String[] args) {
		System.out.println(Joiner.on("|").join("1234", "abcd"));
		
		System.out.println(joinerJoin(new ArrayList<String>() {{
			add("111");
			add("222");
			add(null);
			add("333");
		}}));
		
		Map<String, String> map = new HashMap<>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		MapJoiner mapJoiner = Joiner.on("; ").withKeyValueSeparator("=");
		System.out.println(mapJoiner.join(map));
		
	}
	
	private static String joinerJoin(List<String> strings) {
	    return Joiner.on(",").useForNull("NULL").join(strings);
	}
}
