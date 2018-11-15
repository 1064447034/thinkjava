package thread.serializable.toobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;

public class Main {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/lenovo/Desktop/obj.txt"));
		MyObject obj = MyObject.getInstance();
		obj.setUsername("asssdfaer");
		oos.writeObject(obj);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/lenovo/Desktop/obj.txt"));
		MyObject robj = (MyObject)ois.readObject();
		System.out.println(JSON.toJSONString(robj));
	}
}
