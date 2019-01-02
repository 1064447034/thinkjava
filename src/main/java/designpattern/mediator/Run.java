package designpattern.mediator;

public class Run {
	public static void main(String[] args) {
		JavaQQqun qun = new JavaQQqun();
		ZhangSan zs = new ZhangSan("张三", qun);
		XuWuJing xwj = new XuWuJing("XuWuJing", qun);
		
		zs.talk("大家好！我是张三!");;
	    xwj.talk("欢迎你！张三！");
	}
}
