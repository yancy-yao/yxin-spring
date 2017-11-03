package com.yancy.spring.ioc;

/**
 * Created by yancy on 2017/11/2.
 */
public interface IFxNewsListener {

    String[] getAvaliableNewsIds();

    FxNewsBean getNewsByPK(String newsId);
}
