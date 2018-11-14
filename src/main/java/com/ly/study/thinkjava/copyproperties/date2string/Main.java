package com.ly.study.thinkjava.copyproperties.date2string;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;


public class Main {
	 public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		 SourceDemo sourceDemo = new SourceDemo();
	     sourceDemo.setId(10);
	     sourceDemo.setName("姓名");
	     sourceDemo.setAddress("地址");
	     sourceDemo.setCreateTime(new Date(0));
	     
	     TargetDemo targetDemo = new TargetDemo();
//	     org.springframework.beans.BeanUtils.copyProperties(sourceDemo, targetDemo);
	     org.apache.commons.beanutils.BeanUtils.copyProperties(targetDemo, sourceDemo);
	     System.out.println(sourceDemo);
	     System.out.println(targetDemo);
	     
	     
	}
}
