package com.yancy.spring.ioc;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by yancy on 2017/11/2.
 */
public class FxNewsProvider {

    private IFxNewsListener newsListener;
    private IFxNewsPersister newsPersister;

    public FxNewsProvider(IFxNewsListener newsListener, IFxNewsPersister newsPersister) {
        this.newsListener = newsListener;
        this.newsPersister = newsPersister;
    }

    public void getAndPersistNews() {
        String[] newsIds = newsListener.getAvaliableNewsIds();
        if (ArrayUtils.isEmpty(newsIds)) {
            return;
        }

        for (String newsId : newsIds) {
            FxNewsBean newsBean = newsListener.getNewsByPK(newsId);
            newsPersister.persistNews(newsBean);
            newsPersister.postProcessIfNecessary(newsId);
        }
    }
}
