package designpattern.observer.test1;

public class Main {
	public static void main(String[] args) {
		Observer user1 = new User("zhangsan");
		Observer user2 = new User("lisi");
		
		WechatServer server = new WechatServer();
		server.registerObserver(user1);
		server.registerObserver(user2);
		server.setInfomation("PHP是世界上最好用的语言！");
		
		System.out.println("----------------------------------------------");
		server.removeObserver(user1);
		server.setInfomation("JAVA是世界上最好用的语言！");
	}
	
}
