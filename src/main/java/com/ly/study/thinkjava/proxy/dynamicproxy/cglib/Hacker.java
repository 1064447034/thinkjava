package com.ly.study.thinkjava.proxy.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zbs39170
 */
public class Hacker implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("**** I am a hacker,Let's see what the poor programmer is doing Now...");
		proxy.invokeSuper(obj, args);
		System.out.println("****  Oh,what a poor programmer.....");
		return null;
	}
	
}
