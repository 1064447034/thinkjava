package com.ly.study.thinkjava.copyproperties.date2string;


import java.sql.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SourceDemo {
    
    private int id;
    
    private String name;
    
    private String address;
    
    private Date createTime;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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