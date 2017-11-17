package com.yancy.spring.ioc.factory;

import java.util.Date;

/**
 * NextDayDateDisplayer 所声明的依赖dateOfNextDay的类型为Date，而不是NextDayDateFactoryBean;
 * 也就是说FactoryBean类型的bean定义，通过正常的id引用，容器返回的是FactoryBean所生产的对象类型
 * 而非FactoryBean本身。
 * Created by yancy on 2017/11/17.
 */
public class NextDayDateDisplayer {

    private Date dateOfNextDay;

}
