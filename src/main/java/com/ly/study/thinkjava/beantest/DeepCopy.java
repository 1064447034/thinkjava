package com.ly.study.thinkjava.beantest;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class DeepCopy {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 2);
		KUser u = new KUser("zhang", 11, true);
//		KUser u2 = new KUser("cao", 22, true);
		System.out.println(u);
		
		KUser u2 = new KUser();
		BeanUtils.copyProperties(u2, u);
		System.out.println(u2);
		
		System.out.println();
	}
}
