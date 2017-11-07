package com.yancy.springboot.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * TODO 为了实现服务器启动即执行某些操作，只需要实现spring boot中的CommandLineRunner接口即可
 * Created by yancy on 2017/11/7.
 */
@Component
@Order(value = 1) // 设置启动执行顺序
public class MyCommandRunner1 implements CommandLineRunner {

    private Logger logger = Logger.getLogger("MyCommandRunner1");

    /**
     * TODO 系统启动即会执行Run方法
     */
    @Override
    public void run(String... arg0) throws Exception {
        logger.info("执行启动任务1...");
    }
}
