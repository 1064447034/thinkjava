package com.ly.study.thinkjava.designmodel.builder1;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class Director {
	private Builder builder;
	
	@Test
	public void construct() {
		builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		Product p = builder.retrieveResult();
		System.out.println(JSON.toJSONString(p));
	}
}
