package com.ironhack.homework4.proxyopportunityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyOpportunityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyOpportunityServiceApplication.class, args);
	}

}
