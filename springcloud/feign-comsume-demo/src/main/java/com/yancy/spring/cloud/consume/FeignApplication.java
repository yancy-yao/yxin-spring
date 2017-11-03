package com.yancy.spring.cloud.consume;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class FeignApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(FeignApplication.class).web(true).run(args);
	}
	
}
