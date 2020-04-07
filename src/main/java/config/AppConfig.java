package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import domain.College;
import domain.Student;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"dao"})
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource bean=new DriverManagerDataSource();
		bean.setUrl("jdbc:mysql://localhost/hibernateDemo?useUnicode=true&characterEncoding=UTF-8");
		bean.setPassword("root");
		bean.setUsername("root");
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bean;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager obj=new HibernateTransactionManager(sessionFactory);
		return obj;
	}
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setAnnotatedClasses(Student.class,College.class);
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL55Dialect");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		hibernateProperties.setProperty("hibernate.format_sql","true");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		bean.setHibernateProperties(hibernateProperties);
		return bean;
	}
}
