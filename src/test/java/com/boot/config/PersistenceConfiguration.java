package com.boot.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfiguration {
	// Bean annotation sets up the DataSourceBuilder response as a bean that is added to the classpath
	@Bean
	// ConfigurationProperties tells this Bean to use properties outlined in the application.properties file with the prefix "spring.datasource"
	@ConfigurationProperties(prefix="spring.datasource")
	//Define this as primary datasource in the application
	@Primary
	public DataSource datasource() {
		return DataSourceBuilder.create().build();
	}
	

	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@FlywayDataSource
	public DataSource flywayDataSource() {
		return DataSourceBuilder.create().build();
	}
}
