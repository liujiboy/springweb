package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan(basePackages = { "restcontroller" }, includeFilters = { @Filter(value = Controller.class) })
public class WebMvcConfig extends WebMvcConfigurationSupport {
	

	// 启用处理静态资源
	// 在 WebAppInitializer 中我们映射的 URL 是 "/", 如果 URI 匹配不到资源, 而默认的 Servlet
	// 可以匹配到资源, 那就启用它
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
