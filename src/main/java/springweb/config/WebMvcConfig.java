package springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages = { "springweb.controller","springweb.restcontroller" }, includeFilters = {@Filter(value = Controller.class)})
public class WebMvcConfig extends WebMvcConfigurationSupport {
	@Bean
	public CommonsMultipartResolver multipartResolver()
	{
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(-1);
		resolver.setMaxInMemorySize(-1);
		return resolver;
	}
	@Bean
	public ViewResolver viewResolver()
	{
		UrlBasedViewResolver viewResolver=new UrlBasedViewResolver();
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	
}
