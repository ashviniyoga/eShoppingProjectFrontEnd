package com.ashvini.eShopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"com.ashvini.eShopping.DTO"})
@EnableTransactionManagement
public class HibernateConfig {
	
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshopping";
	private static final String DATABASE_DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "root";

	@Bean
	public DataSource getDataSource() {
		BasicDataSource datasource = new BasicDataSource();
		
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		datasource.setUrl(DATABASE_URL);
		datasource.setDriverClassName(DATABASE_DRIVER);
		
		return datasource;
	}

	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		System.out.println("inside get SessionFact()");
		LocalSessionFactoryBuilder sf = new LocalSessionFactoryBuilder(datasource);
		System.out.println("after SF object created");
				sf.addProperties(getHibernateProperties());
				System.out.println("after add properties");
				sf.scanPackages("com.ashvini.eShopping.DTO");
		System.out.println("after scnannng packages");
			return sf.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		System.out.println("Inside properties()");
		p.put("hibernate.dialect", DATABASE_DIALECT);
		p.put("hibernate.format_sql","TRUE");
		p.put("hibernate.show_sql", "true");
		return p;
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sf) {
		HibernateTransactionManager htm = new HibernateTransactionManager(sf);
		System.out.println("transaction manager" + htm);
		return htm;
	}
}
