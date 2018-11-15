package thread.threadlocal.simpledate.formaterror;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {
	private SimpleDateFormat sdf;
	private String dateString;
	public MyThread(SimpleDateFormat sdf, String dateString) {
		super();
		this.sdf = sdf;
		this.dateString = dateString;
	}
	
	@Override
	public void run() {
		try {
			super.run();
			Date dateRef = sdf.parse(dateString);
			String newDateString = sdf.format(dateRef);
			if (!newDateString.equals(dateString)) {
				System.out.println("ThreadName=" + this.getName()
					+ "报错了 日期字符串：" + dateString + "转换成的日期为：" + newDateString);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
