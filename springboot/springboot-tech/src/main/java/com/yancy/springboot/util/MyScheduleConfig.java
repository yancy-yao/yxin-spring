package com.yancy.springboot.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

/**任务调度
 * Created by yancy on 2017/11/7.
 */
@Configuration // 声明类为系统配置类
@EnableScheduling // 开启调度任务
public class MyScheduleConfig {

    private Logger logger = Logger.getLogger("MyScheduleConfig");

    @Scheduled(cron = "0 0/1 * * * ?") // 定义调度器
    public void job1() {
        logger.info("this is my first job execute");
    }
}
