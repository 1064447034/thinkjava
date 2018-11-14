package com.ly.study.thinkjava.copyproperties.boxing;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TargetDemo {

	private Integer id;

	private String name;

	private String email;

	private Date createTime;

	private Tar t;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Tar getT() {
		return t;
	}

	public void setT(Tar t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}