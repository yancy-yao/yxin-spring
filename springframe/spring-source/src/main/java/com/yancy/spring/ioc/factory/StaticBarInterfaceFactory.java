package com.yancy.spring.ioc.factory;

/**
 * Created by yancy on 2017/11/17.
 */
public class StaticBarInterfaceFactory {

    public static BarInterface getInstance() {
        return new BarInterfaceImpl();
    }
}
