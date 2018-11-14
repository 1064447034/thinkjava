package com.ly.study.thinkjava.designmodel.singleton.classloader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Singleton singleton = Singleton.getInstance();

		MyClassLoader myClassLoader = new MyClassLoader("myClassLoader");
		myClassLoader.setClassPath("E:/java/java_workspace/thinkjava/target/classes");
//		Class singletonClass = myClassLoader.findClass("com.ly.study.thinkjava.singleton.classloader.Singleton");
		Class singletonClass = MyClassLoader.getClass("com.ly.study.thinkjava.singleton.classloader.Singleton");
		System.out.println("singletonClass.getClassLoader() : " + singletonClass.getClassLoader());

		System.out.println("Singleton.class==singletonClass : " + (Singleton.class == singletonClass));
		System.out.println("Singleton.class.equals(singletonClass) : " + (Singleton.class.equals(singletonClass)));

		Constructor constructor1 = Singleton.class.getDeclaredConstructor();
		Constructor constructor3 = singletonClass.getDeclaredConstructor();
		
		constructor1.setAccessible(true);
		Object singleton1 = constructor1.newInstance();
		constructor3.setAccessible(true);
		Object singleton3 = constructor3.newInstance();

		System.out.println("singleton1==singleton3 : "+(singleton1==singleton3));
	}
	
}
