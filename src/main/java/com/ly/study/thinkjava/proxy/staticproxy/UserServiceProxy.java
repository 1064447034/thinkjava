package com.ly.study.thinkjava.proxy.staticproxy;

import com.ly.study.thinkjava.proxy.IUserService;

public class UserServiceProxy implements IUserService {
	// 被代理对象
	private IUserService target;

	// 通过构造方法传入被代理对象
	public UserServiceProxy(IUserService target) {
		this.target = target;
	}

	@Override
	public void add(String name) {
		System.out.println("准备向数据库中插入数据");
		target.add(name);
		System.out.println("插入数据库成功");
	}

}