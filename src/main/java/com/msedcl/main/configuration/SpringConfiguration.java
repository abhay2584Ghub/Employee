package com.msedcl.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfiguration {
	public SpringConfiguration() {
		System.out.println("Default Constructor Called - SpringConfiguration");
	}
	@Bean
	JdbcTemplate getJdbcTemplate() {
		System.out.println("getJdbcTemplate() Called");

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/hibernate_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root123");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
}