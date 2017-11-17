package com.yancy.spring.ioc;

/**
 * Created by yancy on 2017/11/17.
 */
public class DowJonesNewsPersister implements IFxNewsPersister {

    @Override
    public void persistNews(FxNewsBean newsBean) {
        System.out.println("dow jones persist....");
    }

    @Override
    public void postProcessIfNecessary(String newsId) {
        System.out.println("dow jones post....");
    }
}
