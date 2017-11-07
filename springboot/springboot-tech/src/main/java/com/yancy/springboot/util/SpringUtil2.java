package com.yancy.springboot.util;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 不在Spring Boot的扫描包下方式一:
 * 主要是在App.java中使用@Import进行导入。
 而且在SpringUtil2是不需要添加@Component注解
 * Created by yancy on 2017/11/7.
 */
public class SpringUtil2 implements ApplicationContextAware{

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil2.applicationContext == null){
            SpringUtil2.applicationContext = applicationContext;
        }
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("---------------simple.plugin.spring.SpringUtil--------------------------------------");
        System.out.println("========ApplicationContext 配置成功, 在普通类可以通过调用SpringUtils.getAppContext() " +
                                "获取applicationContext 对象,applicationContext="+SpringUtil2.applicationContext+"========");
        System.out.println("---------------------------------------------------------------------");
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    //通过name 获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
    //通过class 获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }
    //通过name,以及Clazz 返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
