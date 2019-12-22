package com.madurobank.customerstatementprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CustomerStatementProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerStatementProcessorApplication.class, args);
	}

}
