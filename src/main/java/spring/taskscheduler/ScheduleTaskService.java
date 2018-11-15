package spring.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleTaskService {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println(dateFormat.format(new Date()));
	}
	
	@Scheduled(cron = "0/2 * * * * ?")
	public void fixTimeExecution() {
		System.out.println(dateFormat.format(new Date()));
	}
	
}
