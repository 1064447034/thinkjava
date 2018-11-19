package designpattern.singleton.enumtest;

public enum MyObject {
	connectionFactory;
	
	private Object connection;
	private MyObject() {
		connection = new Object();
	}
	
	public Object getConnection() {
		return connection;
	}
}
