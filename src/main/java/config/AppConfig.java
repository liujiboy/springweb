package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"dao"})
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource bean=new DriverManagerDataSource();
		bean.setUrl("jdbc:mysql://localhost/book?useUnicode=true&characterEncoding=UTF-8");
		bean.setPassword("root");
		bean.setUsername("root");
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bean;
	}
	@Bean
	@Autowired
	public DataSourceTransactionManager transactionManager(DataSource dataSource)
	{
		DataSourceTransactionManager obj=new DataSourceTransactionManager(dataSource);
		return obj;
	}
}
