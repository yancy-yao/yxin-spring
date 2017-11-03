package com.yancy.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dubbo.api.DemoService;

@RestController
@RequestMapping("/")
public class DemoController {

  @Autowired
  private DemoService demoService;

  @RequestMapping(value = "hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return demoService.sayHello();
  }
  
}
