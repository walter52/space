package com.walter.space.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpaceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceEurekaApplication.class, args);
	}

}
