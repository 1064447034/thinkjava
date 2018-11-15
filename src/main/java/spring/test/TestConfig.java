package spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfig {
	@Bean
	@Profile("dev")
	public TestBean devTestBean() {
		return new TestBean("from dev bean");
	}
	
	@Bean
	@Profile("prod")
	public TestBean prodTestBean() {
		return new TestBean("from prod bean");
	}
	
}
