package com.yancy.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yancy on 2017/11/7.
 */
@RestController                 //标记为：restful
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return "Hello world!";
    }
}
