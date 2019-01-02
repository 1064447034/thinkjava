package jvm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Run {
	public static void main(String[] args) throws ParseException {
		// System.out.println(SubClass.value);
		SuperClass s = new SubClass();

		String flightDateTime = "2019-02-02 19:23:00";
		Date flightDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(flightDateTime);
		String mountEn = new SimpleDateFormat("MMM", Locale.ENGLISH).format(flightDatetime);
		String time = new SimpleDateFormat("HHmm").format(flightDatetime);
		
		System.out.println(mountEn + " " + time);
	}
}
