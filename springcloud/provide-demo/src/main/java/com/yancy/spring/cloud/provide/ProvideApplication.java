package com.yancy.spring.cloud.provide;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProvideApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProvideApplication.class).web(true).run(args);
	}
	
}
