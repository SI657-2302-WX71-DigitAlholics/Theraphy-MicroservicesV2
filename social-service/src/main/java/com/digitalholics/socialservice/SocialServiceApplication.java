package com.digitalholics.socialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SocialServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialServiceApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

}
