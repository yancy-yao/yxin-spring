package com.yancy.springboot.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常捕捉
 * Created by yancy on 2017/11/7.
 */
//即把@CONTROLLERADVICE 注解内部使用@EXCEPTIONHANDLER、@INITBINDER、
//@MODELATTRIBUTE注解的方法应用到所有的 @REQUESTMAPPING注解的方法。非常简单，不过只有当使用
//@EXCEPTIONHANDLER最有用，另外两个用处不大。
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    public void defaultErrorHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
    }
}
