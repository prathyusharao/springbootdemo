package com.sampleproject.springbootdemo.dbdetails;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Setter;
@Setter
@Configuration
@PropertySource("classpath:application.properties")
public class DBDetails {
	
	@Value("${spring.datasource.url}") String url;
	@Value("${spring.datasource.username}") String username;
	@Value("${spring.datasource.password}") String password;
	@Value("${spring.datasource.driverClassName}") String driverClassName;
	
	
    public DBDetails()
    {
    	
    }
	
	public DBDetails(String url, String username, String password, String driverClassName) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClassName = driverClassName;
	}
	
	public String getUrl() {
		return url;
	}
   
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	public String getDriverClassName() {
		return driverClassName;
	} 
  }


