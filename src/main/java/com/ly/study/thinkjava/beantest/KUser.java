package com.ly.study.thinkjava.beantest;

import java.util.Map;

public class KUser {  
    private String name;  
    private Integer age;  
    private boolean single;  
    private Map<Integer,Integer> map;  
      
    public KUser(){}  
      
    public KUser(String name,Integer age,boolean single){  
        this.name = name;  
        this.age = age;  
        this.single = single;  
    }  
      
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public boolean isSingle() {  
        return single;  
    }  
  
    public void setSingle(boolean single) {  
        this.single = single;  
    }  
      
    public Map<Integer, Integer> getMap() {  
        return map;  
    }  
  
    public void setMap(Map<Integer, Integer> map) {  
        this.map = map;  
    }  
  
    public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString(){  
        String str = "name:"+name+" age:"+age+" single:"+single+" ";  
        return str;  
    }  
}  