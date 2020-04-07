package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.SimpleAspect;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages= {"bean"})
public class AppConfig {
	@Bean
	public SimpleAspect simpleAspect()
	{
		return new SimpleAspect();
	}
}
