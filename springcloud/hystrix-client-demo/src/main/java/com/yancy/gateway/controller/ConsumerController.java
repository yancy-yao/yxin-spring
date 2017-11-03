package com.yancy.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yancy.gateway.api.CompGateway;
import com.yancy.gateway.service.ComputeService;

@RestController
public class ConsumerController {
	
	 @Autowired
	 ComputeService computeService;
	 @Autowired
	 RestTemplate restTemplate;
	 
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String add() {
//	     return computeService.addService();
		 return new CompGateway("",restTemplate).syncInvoke();
	 }
}
