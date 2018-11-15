package spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Service;

public class LinuxCondition implements Condition {
	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		return arg0.getEnvironment().getProperty("os.name").contains("Linux");
	}
}
