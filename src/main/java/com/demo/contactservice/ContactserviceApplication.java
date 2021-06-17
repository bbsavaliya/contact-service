package com.demo.contactservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.demo.contactservice.configuration.JpaConfiguration;

@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages = {"com.demo.contactservice"})
public class ContactserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactserviceApplication.class, args);
	}
}