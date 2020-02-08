package com.walter.space.console;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
@Slf4j
public class SpaceConsoleApplication {

	public static void main(String[] args) {

		log.info("**********spring boot starting**********");
		SpringApplication.run(SpaceConsoleApplication.class, args);
		log.info("**********spring boot success**********");
	}
}
