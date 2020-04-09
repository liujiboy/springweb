package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration

public class DataSourceConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource bean = new DriverManagerDataSource();
		bean.setUrl("jdbc:mysql://localhost/hibernateDemo?useUnicode=true&characterEncoding=UTF-8");
		bean.setPassword("root");
		bean.setUsername("root");
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bean;
	}
	
}
