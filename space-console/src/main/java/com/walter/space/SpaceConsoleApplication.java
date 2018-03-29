package com.walter.space;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpaceConsoleApplication {
	private static final Logger LOG = LoggerFactory.getLogger(SpaceConsoleApplication.class);

	public static void main(String[] args) {

		LOG.info("**********spring boot starting**********");
		SpringApplication.run(SpaceConsoleApplication.class, args);
		LOG.info("**********spring boot success**********");
	}
}
