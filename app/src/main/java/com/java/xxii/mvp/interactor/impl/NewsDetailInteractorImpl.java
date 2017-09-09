/*
 * Copyright (c) 2016 咖枯 <java201313@163.com | 3772304@qq.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.java.xxii.mvp.interactor.impl;

import com.java.xxii.App;
import com.java.xxii.common.HostType;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.interactor.NewsDetailInteractor;
import com.java.xxii.repository.network.RetrofitManager;
import com.java.xxii.utils.MyUtils;
import com.java.xxii.utils.TransformUtils;
import com.socks.library.KLog;
import java.util.regex.*;


import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;

/**
 * @author 咖枯
 * @version 1.0 2016/6/4
 */
public class NewsDetailInteractorImpl implements NewsDetailInteractor<NewsDetail> {

    @Inject
    public NewsDetailInteractorImpl() {
    }

    @Override
    public Subscription loadNewsDetail(final RequestCallBack<NewsDetail> callBack, final String newsId) {
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO)
                .getNewsDetailObservable(newsId)
                .compose(TransformUtils.<NewsDetail>defaultSchedulers())
                .subscribe(new Observer<NewsDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.toString());
                        callBack.onError(MyUtils.analyzeNetworkError(e));
                    }

                    @Override
                    public void onNext(NewsDetail newsDetail) {
                        changeNewsDetail(newsDetail);
                        callBack.success(newsDetail);
                    }
                });
    }

    private NewsDetail changeNewsDetail(NewsDetail newsDetail) {
        String newsBody = newsDetail.getNews_Content();
        newsBody = "<p>   " + newsBody;
        newsBody = newsBody.replaceAll("\\s{2,}", "<\\/p><p>　　");
        newsBody = newsBody + "<\\/p>";
        String[] imgSrcs = newsDetail.getNews_Pictures();
        if (isChange(imgSrcs)&&!MyUtils.isTextMode())
            newsBody = changeNewsBody(imgSrcs, newsBody);
        newsDetail.setNews_Content(newsBody);
        return newsDetail;
    }

    private boolean isChange(String[] imgSrcs) {
        return imgSrcs != null && imgSrcs.length >= 1 && App.isHavePhoto();
    }

    private String changeNewsBody(String[] imgSrcs, String newsBody) {
        for (int i = 1; i < imgSrcs.length; i++) {
            String oldChars = "</p><p>　　";
            String newChars;
            newChars = "<\\/p><img src=\"" + imgSrcs[i] + "\" /><p>";
            newsBody = newsBody.replaceFirst(oldChars, newChars);

        }
        return newsBody;
    }
}
