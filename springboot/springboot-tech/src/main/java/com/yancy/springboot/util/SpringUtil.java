package com.yancy.springboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * 在Spring Boot可以扫描的包下:
 * spring工具类，为了更方便的获取spring的applicationContext 直接实现接口ApplicationContextAware
 * 使用@Bean注解，在App.java类中将SpringUtil注解进来
 * Created by yancy on 2017/11/7.
 */
@Component
public class SpringUtil implements ApplicationContextAware {

        private Logger logger = Logger.getLogger("SpringUtil");

        private static ApplicationContext applicationContext;
        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            if (SpringUtil.applicationContext == null) {
                SpringUtil.applicationContext = applicationContext;
            }
            logger.info("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getApplicationContext()" +
                    "获取applicationContext对象,applicationContext="
                            + SpringUtil.applicationContext + "========");
        }

        /**
         * 获取spring上下文
         *
         * @return
         */
        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        public static Object getBean(String beanName) {
            return applicationContext.getBean(beanName);
        }
        public static <T> Object getBean(Class<T> class1) {
            return applicationContext.getBean(class1);
        }
        public static <T> Object getBean(Class<T> class1, String beanName) {
            return applicationContext.getBean(class1, beanName);
        }
}
