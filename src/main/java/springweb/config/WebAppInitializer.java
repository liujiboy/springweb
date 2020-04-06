package springweb.config;

import javax.servlet.Filter;

import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {	
		return new Class[]{DataSourceConfig.class,TransactionConfig.class,ServiceConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {	
		return new Class[]{WebMvcConfig.class};
	}
	@Override
	protected String[] getServletMappings() {	
		return new String[]{"*.do"};
	}
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
//        HiddenHttpMethodFilter filter= new HiddenHttpMethodFilter();
//        filter.doFilter(request, response, filterChain);
        return new Filter[] {characterEncodingFilter};
	}
}