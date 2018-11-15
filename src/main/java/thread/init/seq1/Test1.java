package thread.init.seq1;

public class Test1 {
	public static void main(String[] args) {
		new B();
		new A.C();
	}
}

class A {
	static {
		new P("A--static");
	}
	static P p3 = new P("A--p3");

	private P p1 = new P("A--p1");

	public A() {
		System.out.println("A()");
	}

	private P p2 = new P("A--p2");
	
	{
		new P("A{...}");
	}

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

	static {
		new P("B -- static");
	}

	private P p1 = new P("B --p1");
	static P p3 = new P("B -- p3");

	public B() {
		System.out.println("B()");
	}

	public P p2 = new P("B -- p2");

	{
		new P("B{...}");
	}
}

class P {
	public P(String s) {
		System.out.println(s);
	}
}
