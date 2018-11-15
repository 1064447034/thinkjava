package spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
	@Override
	public void onApplicationEvent(DemoEvent arg0) {
		String msg = arg0.getMsg();
		System.out.println(msg);
	}
	
}
