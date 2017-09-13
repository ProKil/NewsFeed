package com.java.xxii.filter;

import android.support.v4.util.Pair;

import com.java.xxii.greendao.BanKeyword;
import com.java.xxii.greendao.BanKeywordDao;
import com.java.xxii.greendao.BanNewsDao;
import com.java.xxii.greendao.News;
import com.java.xxii.greendao.NewsDao;
import com.java.xxii.mvp.entity.NewsSummary;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static com.java.xxii.App.getBanKeywordDao;
import static com.java.xxii.App.getBanNewsDao;
import static com.java.xxii.App.getNewsDao;

/**
 * Created by Hao on 09/09/2017.
 */

public class RecommandationFilter implements BaseFilter<NewsSummary> {
    @Override
    public List filterFrom(List<NewsSummary> original) {
        List<NewsSummary> result;
        try {
            NewsDao newsDao = getNewsDao();
            List<News> viewedNewsList = newsDao.loadAll();
            ArrayList<Pair<Double, NewsSummary>> forSort = new ArrayList<Pair<Double, NewsSummary>>();
            ArrayList<String> keywordList = new ArrayList<>();
            for (News i : viewedNewsList)
                keywordList.add(i.getKey_Words());

            result = original.getClass().newInstance();
            for(NewsSummary i : original){
                double score = 0;
                for (String j : keywordList)
                    if(i.getNews_Title().contains(j))
                        score -= 1;
                forSort.add(Pair.create(score, i));
            }
            Collections.sort(forSort, new Comparator<Pair<Double, NewsSummary>>() {
                @Override
                public int compare(Pair<Double, NewsSummary> o1, Pair<Double, NewsSummary> o2) {
                    if (o1.first > o2.first) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
            for(Pair<Double, NewsSummary> i : forSort) {
                result.add(i.second);
//                break;
            }
            return result;
        } catch (Exception e) {
            KLog.e(e);
            return original;
        }
    }
}
