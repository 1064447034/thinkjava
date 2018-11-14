package com.ly.study.thinkjava.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zbs39170
 */
public class Main {
	public static void main(String[] args) {
		Programer programer = new Programer();
		Hacker hacker = new Hacker();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(programer.getClass());
		enhancer.setCallback(hacker);
		Programer proxy = (Programer)enhancer.create();
		proxy.code();
		
	}
}
