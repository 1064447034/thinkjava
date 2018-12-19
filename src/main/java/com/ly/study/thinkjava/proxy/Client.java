package com.ly.study.thinkjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	public void request();
}

class RealSubject implements Subject {
	public RealSubject() {
		
	}
	@Override
	public void request() {
		System.out.println("from real subject");
	}
}

class DynamicProxy implements InvocationHandler {
	private Object sub;
	public DynamicProxy(Object sub) {
		this.sub = sub;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
		System.out.println("before calling: " + method);
		method.invoke(sub, args);
		System.out.println("after calling: " + method);
		return null;
	}
}

public class Client {
	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		InvocationHandler ds = new DynamicProxy(rs);

//		Subject subject = (Subject)Proxy.newProxyInstance(rs.getClass().getClassLoader(), rs.getClass().getInterfaces(), ds);
		Subject subject = (Subject)Proxy.newProxyInstance(rs.getClass().getClassLoader(), new Class[] { Subject.class }, ds);
		System.out.println(subject);
		subject.request();
	}
	
}
