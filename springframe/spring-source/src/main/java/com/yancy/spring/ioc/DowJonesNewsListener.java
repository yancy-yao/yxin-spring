package com.yancy.spring.ioc;

/**
 * Created by yancy on 2017/11/17.
 */
public class DowJonesNewsListener implements IFxNewsListener{

    @Override
    public String[] getAvaliableNewsIds() {
        System.out.println("dow jones get....");
        return new String[0];
    }

    @Override
    public FxNewsBean getNewsByPK(String newsId) {
        System.out.println("dow jones get....");
        return null;
    }
}
