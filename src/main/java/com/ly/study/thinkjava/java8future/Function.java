package com.ly.study.thinkjava.java8future;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

public class Function {
	public static void main(String args[]) throws Exception {
		// 构建多值Map样例代码
		Map<String, HashSet<String>> map1 = new HashMap<>();
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("apple");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("orange");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("pear");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("banana");
		map1.computeIfAbsent("fruits", k -> genValue(k)).add("water");
		System.out.println(map1);
	
		Map<String, String> map2 = new ConcurrentHashMap<>();
		map2.computeIfAbsent("key", x->getValue2(x));
		System.out.println(map2);
	}

	static HashSet<String> genValue(String str) {
		return new HashSet<String>();
	}
	
	static String getValue2(String key) {
		if (!StringUtils.isEmpty(key)) {
			return "value";
		}
		return "";
	} 
}
