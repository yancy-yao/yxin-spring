package com.yancy.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by yancy on 2017/11/20.
 */
@Aspect
public class YourAspect {

    @Pointcut("aspectj style pointcut expression")
    public void pointcutMethod(){}

    @Pointcut("aspectj style pointcut expression")
    public void pointcutMethod2(){}


    @Pointcut("execution(void method1())")
    public void method1Execution(){}

    @Pointcut("method1Execution()")
    public void stillMethod1Execution(){}
}
