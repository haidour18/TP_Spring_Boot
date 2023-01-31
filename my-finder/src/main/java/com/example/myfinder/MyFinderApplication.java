package com.example.myfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class MyFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFinderApplication.class, args);
	}

}
