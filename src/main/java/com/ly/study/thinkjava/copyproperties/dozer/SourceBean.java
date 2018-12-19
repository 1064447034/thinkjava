package com.ly.study.thinkjava.copyproperties.dozer;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dozer.Mapping;

public class SourceBean {
	private Long id;

	private String name;

	@Mapping("binaryData")
	private String data;

	private Inner inner;

	@Mapping("pk")
	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
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
