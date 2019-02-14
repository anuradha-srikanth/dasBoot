package com.boot.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfiguration {
//	// Bean annotation sets up the DataSourceBuilder response as a bean that is added to the classpath
//	@Bean
//	// ConfigurationProperties tells this Bean to use properties outlined in the application.properties file with the prefix "spring.datasource"
//	@ConfigurationProperties(prefix="spring.datasource")
//	//Define this as primary datasource in the application
//	@Primary
//	public DataSource datasource() {
//		return DataSourceBuilder.create().build();
//	}
//	
//
//	@Bean
//	@ConfigurationProperties(prefix="datasource.flyway")
//	@FlywayDataSource
//	public DataSource flywayDataSource() {
//		return DataSourceBuilder.create().build();
//	}
	
	
	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties firstDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@Primary
	@ConfigurationProperties("spring.datasource.tomcat")
	public HikariDataSource firstDataSource() {
		return firstDataSourceProperties().initializeDataSourceBuilder()
				.type(HikariDataSource.class).build();
	}

	@Bean
	@ConfigurationProperties("datasource.flyway")
	public DataSourceProperties secondDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("datasource.flyway.configuration")
	@FlywayDataSource
	public BasicDataSource secondDataSource() {
		return secondDataSourceProperties().initializeDataSourceBuilder()
				.type(BasicDataSource.class).build();
}

}