package thread.init;

public class Test2 {
	public static void main(String[] args) {
		new B();
		new A.C();
	}
}

class A {
	static P p3 = new P("A--p3");

	// 静态初始化块提前
	static {
		new P("A--static");
	}
	private P p1 = new P("A--p1");
	// 非静态初始化块提前
	{
		new P("A{...}");
	}

	public A() {
		System.out.println("A()");
	}

	private P p2 = new P("A--p2");

	public static class C {
		private P p1 = new P("C--p1");
		static P p3 = new P("C--p3");

		public C() {
			System.out.println("C()");
		}

		private P p2 = new P("C--p2");
		static {
			new P("C--static");
		}
		{
			new P("C{...}");
		}
	}
}

class B extends A {
	private P p1 = new P("B --p1");
	static P p3 = new P("B -- p3");

	public B() {
		System.out.println("B()");
	}

	public P p2 = new P("B -- p2");
	// 静态初始化块置后
	static {
		new P("B -- static");
	}
	{
		new P("B{...}");
	}
}

class P {
	public P(String s) {
		System.out.println(s);
	}
}
