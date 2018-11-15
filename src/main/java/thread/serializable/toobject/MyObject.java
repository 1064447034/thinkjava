package thread.serializable.toobject;

import java.io.Serializable;

public class MyObject implements Serializable {
	private static final long serialVersionUID = 4282000991004796172L;
	
	private static Integer i = 230;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private static class MyObjectHandler {
		private final static MyObject myObject = new MyObject();
	}
	
	private MyObject() {
	}
	public static MyObject getInstance() {
		return MyObjectHandler.myObject;
	}
}
