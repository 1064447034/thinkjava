package com.ly.study.thinkjava.copyproperties.boxing;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;


public class Main {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		SourceDemo sourceDemo = new SourceDemo();
	    sourceDemo.setId(10);
	    sourceDemo.setName("姓名");
	    sourceDemo.setAddress("地址");
	    sourceDemo.setCreateTime(new Date());
	    
	    Tar t = new Tar();
	    t.setId("001");
	    sourceDemo.setT(t);
	    
	    System.out.println(sourceDemo);
	    
	    TargetDemo targetDemo = new TargetDemo();
	    org.apache.commons.beanutils.BeanUtils.copyProperties(targetDemo, sourceDemo);
	    System.out.println(targetDemo);
	    
	    targetDemo.getT().setId("002");
	    
	    System.out.println();
	    System.out.println(sourceDemo);
	    System.out.println(targetDemo);
	}
}
