package com.ly.study.thinkjava.copyproperties.dozer;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;

public class Copy {
	public static void main(String[] args) {
		SourceBean sourceBean = new SourceBean();
		sourceBean.setId(100L);
		sourceBean.setData("sourceData");
		sourceBean.setName("sourceName");
		Inner inner = new Inner();
		inner.setId("00001");
		sourceBean.setInner(inner);
		System.out.println(sourceBean);
		
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		TargetBean target = mapper.map(sourceBean, TargetBean.class);
		System.out.println(target);
		
		target.getInner().setId("0002");
		System.out.println(sourceBean);
		System.out.println(target);
		
	}
}
