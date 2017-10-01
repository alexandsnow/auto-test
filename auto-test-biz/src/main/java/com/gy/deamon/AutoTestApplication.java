package com.gy.deamon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoTestApplication.class, args);
	}
}
