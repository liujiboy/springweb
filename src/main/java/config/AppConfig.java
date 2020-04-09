package config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages= {"repository"})
@EnableTransactionManagement
@ComponentScan(basePackages = { "service" })
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource bean = new DriverManagerDataSource();
		bean.setUrl("jdbc:mysql://localhost/hibernateDemo?useUnicode=true&characterEncoding=UTF-8");
		bean.setPassword("root");
		bean.setUsername("root");
		bean.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return bean;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(DataSource dataSource,EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager();
		tm.setEntityManagerFactory(emf);
		tm.setDataSource(dataSource);
		return tm;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpa = new HibernateJpaVendorAdapter();
		jpa.setDatabase(Database.MYSQL);
		jpa.setShowSql(true);
		jpa.setDatabasePlatform("org.hibernate.dialect.MySQL55Dialect");
		return jpa;
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setJpaVendorAdapter(jpaVendorAdapter);
		bean.setPackagesToScan("domain");
		return bean;
	}
}
