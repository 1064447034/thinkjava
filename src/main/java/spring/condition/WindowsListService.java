package spring.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(WindowsCondition.class)
public class WindowsListService implements ListService {
	@Override
	public String showListCmd() {
		return "dir";
	}
	
}
