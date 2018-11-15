package enumtest;

interface I1 {
	void f();
}
interface I2 {
	int f(int i);
}
interface I3 {
	int f();
}
class C {
	public int f() {
		System.out.println("C");
		return 1;
	}
}
class C2 implements I1, I2 {
	public void f() {
		System.out.println("c2 f()");
	}
	public int f(int i) {
		System.out.println("c2 f(int i)");
		return 1;
	}
}
public class Test2 {
	
}
