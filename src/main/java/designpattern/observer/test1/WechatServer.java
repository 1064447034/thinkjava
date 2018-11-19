package designpattern.observer.test1;

import java.util.ArrayList;
import java.util.List;

public class WechatServer implements Observerable {
	private List<Observer> list;
	private String message;
	
	public WechatServer() {
		list = new ArrayList<Observer>();
	}
	
	@Override
	public void registerObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		if(!list.isEmpty()) {
			list.remove(o);			
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer obj : list) {
			obj.update(message);
		}
	}
	
	public void setInfomation(String s) {
		this.message = s;
		System.out.println("微信服务更新消息： " + s);
		notifyObserver();
	}
	
}
