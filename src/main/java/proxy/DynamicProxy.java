package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

interface Moveable {
	void move();
	void print(String name);
}

class Car implements Moveable {

	@Override
	public void move() {
		// 实现开车
		try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车行驶中....");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void print(String name) {
		System.out.println("name: " + name);
	}

}

class TimeHandler implements InvocationHandler {

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	private Object target;

	/*
	 * 参数： proxy 被代理对象 method 被代理对象的方法 args 方法的参数
	 * 
	 * 返回值： Object 方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//		long starttime = System.currentTimeMillis();
//		System.out.println("汽车开始行驶....");
//		method.invoke(target);
//		long endtime = System.currentTimeMillis();
//		System.out.println("汽车结束行驶....  汽车行驶时间：" + (endtime - starttime) + "毫秒！");

		method.invoke(target, args);
		return null;
	}

}

public class DynamicProxy {
	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		/**
		 * loader 类加载器 interfaces 实现接口 h InvocationHandler
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();
		
		m.print("this is  a test");
	}

}
