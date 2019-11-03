package com.hqyj.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class SbErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbErpApplication.class, args);
	}

}
