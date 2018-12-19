package com.ly.study.thinkjava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Serialize {
	private ByteArrayOutputStream baos;
	private ObjectOutputStream oos;

	private ByteArrayInputStream bais;
	private ObjectInputStream ois;

	private User user;

	public Serialize() {
		user = new User();
		user.setId(1);
		user.setUserName("云中龙");
		user.setUserPwd("root");
		user.setAge(21);
	}

	// 序列化
	public void output() throws Exception {
		baos = new ByteArrayOutputStream();
		oos = new ObjectOutputStream(baos);
		oos.writeObject(user);
		System.out.println("ByteArrayOutputStream对象输出:" + baos);
		baos.close();
		oos.close();
	}

	// 对象进行反序列化成实体对象
	public User input() throws Exception {
		bais = new ByteArrayInputStream(baos.toByteArray());
		ois = new ObjectInputStream(bais);
		Object object = ois.readObject();
		bais.close();
		ois.close();
		return (User) object;
	}

	DataOutputStream dos;
	DataInputStream dis;
	// 序列化
	String str;

	public void doutput() throws Exception {
		baos = new ByteArrayOutputStream();
		dos = new DataOutputStream(baos);
		dos.writeInt(2);
		dos.writeUTF(new String("松松"));
		dos.writeUTF("root");
		dos.writeInt(user.getAge());
		str = new String(baos.toByteArray());
		/*
		 * 注意若以UTF-8编码格式写入到ByteArrayOutputStream流对象中再将其toByteArray构造成String类型
		 * 再次改成字节进行反序列化时可能会抛出java.io.UTFDataFormatException: malformed input
		 * around byte 44异常； 例如字符串中加入"胡"字时抛出java.io.UTFDataFormatException:异常信息
		 * 奇怪的是如果字符串为英文格式时运行正常，具体原因有待研究 若直接用ByteArrayOutputStream
		 * toByteArray获取的字节数组进行反序列构造对时不会抛出异常
		 */
		System.out.println("构造字符串输出:" + str);
		baos.close();
		dos.close();
	}

	// 对象进行反序列化构建新的实体对象
	public User dinput() throws Exception {
		bais = new ByteArrayInputStream(str.getBytes());
		dis = new DataInputStream(bais);
		User user = new User();
		user.setId(dis.readInt());
		user.setUserName(dis.readUTF());
		user.setUserPwd(dis.readUTF());
		user.setAge(dis.readInt());
		bais.close();
		dis.close();
		return user;
	}

	// 测试函数
	public static void main(String[] args) {
		Serialize ms = new Serialize();
		try {
			System.out.println("--------------------方法一效果------------------------");
			ms.output();
			User user = ms.input();
			System.out.println("\tuserid:" + user.getId() + "\tuserName:" + user.getUserName() + "\tuserPwd:"
					+ user.getUserPwd() + "\tuserAge:" + user.getAge() + "\n");
			System.out.println("------------------方法二效果---------------------------");
			ms.doutput();
			User user2 = ms.dinput();
			System.out.println("\tuserid:" + user2.getId() + "\tuserName:" + user2.getUserName() + "\tuserPwd:"
					+ user2.getUserPwd() + "\tuserAge:" + user2.getAge());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

class User implements java.io.Serializable{
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