package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Configuration

@ComponentScan(basePackages = { "service" }, includeFilters = {@Filter(value = Service.class)})
public class ServiceConfig {

}
