package hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	@Bean
	@Scope("singleton")
	public FifoQueue fifoQueue() {
        	return new FifoQueue();
    }

	@Bean
	@Scope("singleton")
	public BishBashBosh bishBashBosh() {
        	return new BishBashBosh();
    }


}