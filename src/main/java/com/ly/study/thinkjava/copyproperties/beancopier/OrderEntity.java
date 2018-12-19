package com.ly.study.thinkjava.copyproperties.beancopier;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class OrderEntity {
	private int id;  
    private String name;
	private Tar tar;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	public Tar getTar() {
		return tar;
	}
	public void setTar(Tar tar) {
		this.tar = tar;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
