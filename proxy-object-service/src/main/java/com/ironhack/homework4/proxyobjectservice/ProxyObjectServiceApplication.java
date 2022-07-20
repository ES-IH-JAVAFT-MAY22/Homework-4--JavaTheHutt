package com.ironhack.homework4.proxyobjectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyObjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyObjectServiceApplication.class, args);
	}

}
