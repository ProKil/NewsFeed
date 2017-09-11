package com.java.xxii.filter;

import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.entity.NewsSummary;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Hao on 09/09/2017.
 */

public class KeywordFilter implements BaseFilter<NewsSummary>{
    @Override
    public List<NewsSummary> filterFrom(List<NewsSummary> original) {
        List<NewsSummary> result;
        try {
            result = original.getClass().newInstance();
            for(NewsSummary i : original){
                if(!i.getNews_Title().contains("iPhone 7")){
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
