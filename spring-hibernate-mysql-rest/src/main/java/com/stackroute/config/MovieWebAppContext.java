package com.stackroute.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.stackroute.model.Book;
import com.stackroute.model.User;


@Configuration
@ComponentScan("com.stackroute")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class MovieWebAppContext {

	@Value("${jdbc.drverClass}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String dbUrl;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	
	@Bean
	public BasicDataSource getDatasource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(dbUrl);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource ds) throws IOException {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		
		sf.setDataSource(ds);
		sf.setAnnotatedClasses(Book.class,User.class);
		
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
//		create
		sf.setHibernateProperties(properties);
		
		sf.afterPropertiesSet();
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory);
		return transaction;
	}

	
}



//Managing the database connection - Apache dbcp2
//configuring session factory for getting the session
//configure hibernate properties
//configure transaction management
