package com.ly.study.thinkjava.copyproperties.boxing;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Tar {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
