package com.yancy.spring.cloud.consume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.yancy.spring.cloud.consume.service.ComputeService;

@RestController
public class ConsumerController {
	
	 @Autowired
	 ComputeService computeService;
	 
	 @RequestMapping(value = "/add", method = RequestMethod.GET)
	 public String add() {
	     return computeService.addService();
	 }
}
