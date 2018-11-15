package thread.threadlocal.simpledate.formatok;

import java.text.SimpleDateFormat;

public class MyThread {
	private ThreadLocal<SimpleDateFormat> sdf;
	private String dateString;

	public MyThread(ThreadLocal<SimpleDateFormat> sdf, String dateString) {
		super();
		this.sdf = sdf;
		this.dateString = dateString;
	}
}
