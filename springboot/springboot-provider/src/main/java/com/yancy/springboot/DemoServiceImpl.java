package com.yancy.springboot;

import com.dubbo.api.DemoService;

public class DemoServiceImpl implements DemoService{

	@Override
	public String sayHello() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Spring Boot say hi to Dubbo!";
	}
}
