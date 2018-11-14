package com.ly.study.thinkjava.copyproperties.string2date;


import java.sql.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class TargetDemo {
    
    private Integer id;
    
    private String name;
    
    private String email;
    
    private Date createTime;
	private Inner inner;
	
	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}
	public static class Inner {
		private String type = "inner";

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	
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
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}