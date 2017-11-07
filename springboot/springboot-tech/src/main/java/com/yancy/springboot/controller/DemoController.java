package com.yancy.springboot.controller;

import com.yancy.springboot.bean.Demo;
import com.yancy.springboot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yancy on 2017/11/7.
 */
@Controller
@RequestMapping("/demo2")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/save")
    public String save(){
        demoService.save(new Demo());
        return "ok";
    }
}
