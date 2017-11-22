package com.yancy.spring.tx;

/**
 * Created by yancy on 2017/11/21.
 */
public class TransactionResourceManager {

    private static ThreadLocal resources = new ThreadLocal();

    public static Object getResource(){
        return resources.get();
    }

    public static void bindResource(Object resource){
        resources.set(resource);
    }

    public static Object unbindResource(){
        Object res = getResource();
        resources.set(null);
        return res;
    }
}
