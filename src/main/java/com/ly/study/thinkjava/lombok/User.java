package com.ly.study.thinkjava.lombok;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String name;
	private String phone;
	
	public static void main(String[] args) {
		User u = new User();
		System.out.println(u);
		
	}
}
