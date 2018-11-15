package spring.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(LinuxCondition.class)
public class LinuxListService implements ListService {
	@Override
	public String showListCmd() {
		return "ls";
	}
}
