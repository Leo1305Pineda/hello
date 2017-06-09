package com.pedrocamejo;


//import org.flywaydb.core.Flyway;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AvailableSettings;
//import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
/*import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
*/
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan("com.pedrocamejo")
@EnableTransactionManagement
public class ApplicationModelsConfiguration {
	/*
	@Bean
	public Flyway flayway(SingleConnectionDataSource dataSource) {
		Flyway flayway = new Flyway();
		flayway.setBaselineOnMigrate(false);
		flayway.setLocations("classpath:/migrations");
		flayway.setDataSource(dataSource);
		flayway.migrate();
		return flayway;
	}

	@Bean
	public SingleConnectionDataSource dataSource() {
		SingleConnectionDataSource  datasource = new SingleConnectionDataSource();
		datasource.setDriverClassName("org.postgresql.Driver");
		datasource.setUrl("jdbc:postgresql://localhost:5432/hello");
		datasource.setUsername("postgres");
		datasource.setPassword("1234");
		datasource.setSuppressClose(true);
		return datasource;
	}


	 @Bean
     public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	 }
	@Bean
	public LocalSessionFactoryBean sessionFactory(SingleConnectionDataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Properties properties = new Properties();
		properties.setProperty(AvailableSettings.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty(AvailableSettings.SHOW_SQL,"true");
		properties.setProperty(AvailableSettings.HBM2DDL_AUTO,"none");
		properties.setProperty(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS,"org.springframework.orm.hibernate5.SpringSessionContext");
		sessionFactory.setPackagesToScan("com.pedrocamejo.models");
	    sessionFactory.setHibernateProperties(properties);
	    return sessionFactory;
	} 
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
*/

}
