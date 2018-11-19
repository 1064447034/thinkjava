package designpattern.singleton.classloader;

public class Singleton {
	private static final Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}

	private static Class getClass(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		if (classLoader == null)
			classLoader = Singleton.class.getClassLoader();
		return (classLoader.loadClass(classname));
	}

}
