package com.ly.study.thinkjava.proxy.staticproxy;

import com.ly.study.thinkjava.proxy.IUserService;
import com.ly.study.thinkjava.proxy.UserServiceImpl;

public class StaticProxyTest {
	public static void main(String[] args) {
		IUserService target = new UserServiceImpl();
		UserServiceProxy proxy = new UserServiceProxy(target);
		proxy.add("陈粒");
	}
}
