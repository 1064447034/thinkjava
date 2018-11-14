package com.ly.study.thinkjava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;

public class MyTest {
	private User2 user;

	public MyTest() {
		user = new User2();
		user.setId(1);
		user.setUserName("云中龙");
		user.setUserPwd("root");
		user.setAge(21);
	}

	ByteArrayOutputStream bos = null;

	public void input() throws IOException {
		bos = new ByteArrayOutputStream();
		ObjectOutputStream dos = new ObjectOutputStream(bos);
		dos.writeObject(user);
		dos.close();
		bos.close();
	}

	public void output() throws IOException, ClassNotFoundException {
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		User2 user = (User2) ois.readObject();
		System.out.println(JSON.toJSONString(user));
		ois.close();
		bis.close();
	}

	ByteArrayOutputStream bos2;
	public void doutput() throws IOException {
		bos2 = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos2);
		dos.writeInt(2);
		dos.writeUTF(new String("松松"));
		dos.writeUTF("root");
		dos.writeInt(user.getAge());
	}

	// 对象进行反序列化构建新的实体对象
	public void dinput() throws Exception {
		ByteArrayInputStream bais = new ByteArrayInputStream(bos2.toByteArray());
		DataInputStream dis = new DataInputStream(bais);
		User2 user = new User2();
		user.setId(dis.readInt());
		user.setUserName(dis.readUTF());
		user.setUserPwd(dis.readUTF());
		user.setAge(dis.readInt());
		bais.close();
		dis.close();
		System.out.println(JSON.toJSONString(user));
	}

	public static void main(String[] args) throws Exception {
		MyTest ms = new MyTest();
		ms.input();
		ms.output();
		
		ms.doutput();
		ms.dinput();
	}
}

class User2 implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String userName;
	private String userPwd;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}