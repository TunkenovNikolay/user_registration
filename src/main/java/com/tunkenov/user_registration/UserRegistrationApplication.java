package com.tunkenov.user_registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class UserRegistrationApplication {
	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
		logger.info("Приложение запустилось.");
	}
}
