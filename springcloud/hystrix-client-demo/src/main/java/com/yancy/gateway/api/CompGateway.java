package com.yancy.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.yancy.gateway.MyGateWay;

public class CompGateway extends MyGateWay{

	 @Autowired
	 RestTemplate restTemplate;
	 
	public CompGateway(String content, RestTemplate restTemplate) {
		super(content);
		this.restTemplate = restTemplate;
	}

	@Override
	public String doWork(String request) {
		try{
			return restTemplate.getForEntity("http://PROVIDE-SERVICE/add?a=10&b=20", String.class).getBody();
		} catch(Exception e){
			e.printStackTrace();
		}
		return getFallback();
	}

	@Override
	public void subscribeOnCompleted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeOnError() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subscribeOnNext() {
		// TODO Auto-generated method stub
		
	}
}
