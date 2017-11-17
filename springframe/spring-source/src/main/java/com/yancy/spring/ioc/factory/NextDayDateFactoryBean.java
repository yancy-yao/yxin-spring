package com.yancy.spring.ioc.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Date;

/**
 * Created by yancy on 2017/11/17.
 */
public class NextDayDateFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new Date();
    }

    @Override
    public Class<?> getObjectType() {
        return Date.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
