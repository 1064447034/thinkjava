package com.ly.study.thinkjava.copyproperties.dozer;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TargetBean {
	private String pk;

	private String name;

	private String binaryData;
	
	private Inner inner;

	public void setPk(String pk) {
		this.pk = pk;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBinaryData() {
		return binaryData;
	}

	public void setBinaryData(String binaryData) {
		this.binaryData = binaryData;
	}

	public String getPk() {
		return pk;
	}

	public String getName() {
		return name;
	}
	
	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
