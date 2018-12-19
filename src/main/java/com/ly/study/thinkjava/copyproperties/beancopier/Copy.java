package com.ly.study.thinkjava.copyproperties.beancopier;

import org.junit.Test;

import net.sf.cglib.beans.BeanCopier;

public class Copy {
	@Test
	public void normalCopyTest() {
		OrderEntity entity = new OrderEntity();
		entity.setId(1);
		entity.setName("orderName");
		Tar tar = new Tar();
		tar.setId("001");
		entity.setTar(tar);
		
		BeanCopier copier = BeanCopier.create(OrderEntity.class, OrderDto.class, false);
		
		OrderDto dto = new OrderDto();
		copier.copy(entity, dto, null);
		System.out.println(entity);
		System.out.println(dto);
		
		System.out.println();
		dto.getTar().setId("002");
		
		System.out.println(entity);
		System.out.println(dto);
	}
}
