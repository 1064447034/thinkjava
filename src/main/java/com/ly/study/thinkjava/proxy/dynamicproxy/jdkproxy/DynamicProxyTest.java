package com.ly.study.thinkjava.proxy.dynamicproxy.jdkproxy;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import com.ly.study.thinkjava.proxy.IUserService;
import com.ly.study.thinkjava.proxy.UserServiceImpl;

import sun.misc.ProxyGenerator;

public class DynamicProxyTest {
	public static void main(String[] args) {

		IUserService target = new UserServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(target);
		// 第一个参数是指定代理类的类加载器（我们传入当前测试类的类加载器）
		// 第二个参数是代理类需要实现的接口（我们传入被代理类实现的接口，这样生成的代理类和被代理类就实现了相同的接口）
		// 第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
		IUserService proxyObject = (IUserService)Proxy.newProxyInstance(DynamicProxyTest.class.getClassLoader(),
				target.getClass().getInterfaces(), handler);
		proxyObject.add("陈粒");
		
		String path = "E:/$Proxy0.class";
		byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());
		
		try (FileOutputStream out = new FileOutputStream(path)){
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
