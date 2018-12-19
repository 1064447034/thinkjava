package com.ly.study.thinkjava.classpath;

public class Resource {
	public static void main(String[] args) {
		new Resource().func();
	}
	
	public void func() {
		System.out.println(Resource.class.getResource("/").toString());
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("/").getPath());
	}
}
