package designpattern.singleton.enumtest2;

public class MyObject {
	public enum MyEnumSingleton {
		connectionFactory;
		private Object connection;
		private MyEnumSingleton() {
			try {
				System.out.println("创建MyObject对象");
				connection = new Object();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		public Object getConnection() {
			return connection;
		}
	}
	
	public static Object getConnection() {
		return MyEnumSingleton.connectionFactory.getConnection();
	}
}
