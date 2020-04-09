package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = { "restcontroller" }, includeFilters = {@Filter(value = Controller.class)})
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
}
