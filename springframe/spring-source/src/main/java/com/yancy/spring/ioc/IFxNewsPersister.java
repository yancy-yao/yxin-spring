package com.yancy.spring.ioc;

/**
 * Created by yancy on 2017/11/2.
 */
public interface IFxNewsPersister {

    void persistNews(FxNewsBean newsBean);

    void postProcessIfNecessary(String newsId);
}
