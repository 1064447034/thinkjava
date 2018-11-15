package spring.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTaskService {
	@Async
	public void executeAsyncTask(Integer i) {
		System.out.println(i);
	}
	
	@Async
	public void executeAynchTaskPlus(Integer i) {
		System.out.println(i++);
	}
}
