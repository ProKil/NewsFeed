package com.java.xxii.filter;

import com.java.xxii.App;
import com.java.xxii.greendao.BanKeyword;
import com.java.xxii.greendao.BanKeywordDao;
import com.java.xxii.greendao.BanNews;
import com.java.xxii.greendao.BanNewsDao;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.entity.NewsSummary;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static com.java.xxii.App.getBanKeywordDao;
import static com.java.xxii.App.getBanNewsDao;

/**
 * Created by Hao on 09/09/2017.
 */

public class KeywordFilter implements BaseFilter<NewsSummary>{
    @Override
    public List<NewsSummary> filterFrom(List<NewsSummary> original) {
        List<NewsSummary> result;
        try {
            BanNewsDao banNewsDao = getBanNewsDao();
            BanKeywordDao banKeywordDao = getBanKeywordDao();
            List<BanKeyword> banKeywordList = banKeywordDao.loadAll();

            result = original.getClass().newInstance();
            for(NewsSummary i : original){
                if(banNewsDao.queryBuilder().where(BanNewsDao.Properties.News_ID.eq(i.getNews_ID())).list().size() == 0){
                    try {
                        for (BanKeyword j : banKeywordList)
                            if (i.getNews_Title().contains(j.getKeyword()))
                                throw new NullPointerException();
                    }
                    catch (Exception e){
                        continue;
                    }
                    result.add(i);
                }
            }
            return result;
        } catch (Exception e) {
            KLog.e(e);
            return original;
        }

    }
}
