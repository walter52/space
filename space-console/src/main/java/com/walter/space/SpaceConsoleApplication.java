package com.walter.space;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpaceConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceConsoleApplication.class, args);
		System.out.println("spring boot 启动");
	}
}
