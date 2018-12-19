package com.ly.study.thinkjava;

import java.lang.reflect.Method;

public class InnerTest {
	public static void main(String[] args) {
		A a = InnerA.makeA();
		a.f();
	}
	
	static void callHiddenMethod(Object a, String methodName) throws Exception {
		Method g = a.getClass().getMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}

interface A {
	void f();
}

class InnerA {
	private static class C implements A {
		@Override
		public void f() {
			System.out.println("public C.f()");
		}
		public void g() {
			System.out.println("public C.g()");
		}
		public void u() {
			System.out.println("package C.u()");
		}
		protected void v() {
			System.out.println("protected C.v()");
		}
		private void w() {
			System.out.println("private C.w()");
		}
	}
	public static A makeA() {
		return new C();
	}
}