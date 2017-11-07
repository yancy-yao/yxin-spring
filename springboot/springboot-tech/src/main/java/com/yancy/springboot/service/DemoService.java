package com.yancy.springboot.service;

import com.yancy.springboot.bean.Demo;
import com.yancy.springboot.entity.IDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by yancy on 2017/11/7.
 */
@Service("demoService")
public class DemoService {

    @Autowired
    private IDemoRepository demoRepository;

    @Transactional
    public void save(Demo demo){
        demoRepository.save(demo);
    }
}
