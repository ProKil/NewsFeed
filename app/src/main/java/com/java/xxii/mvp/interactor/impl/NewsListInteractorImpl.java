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

import com.java.xxii.common.ApiConstants;
import com.java.xxii.common.HostType;
import com.java.xxii.filter.KeywordFilter;
import com.java.xxii.filter.RecommandationFilter;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.mvp.entity.NewsSummaryRetrieve;
import com.java.xxii.mvp.interactor.NewsListInteractor;
import com.java.xxii.repository.network.RetrofitManager;
import com.java.xxii.utils.MyUtils;
import com.java.xxii.utils.TransformUtils;
import com.socks.library.KLog;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * @author 咖枯
 * @version 1.0 2016/5/19
 */
public class NewsListInteractorImpl implements NewsListInteractor<List<NewsSummary>> {

//    private boolean mIsNetError;

    @Inject
    public NewsListInteractorImpl() {
    }

    @Override
    public Subscription loadNews(final RequestCallBack<List<NewsSummary>> listener, String type,
                                 final String id, int startPage) {
//        mIsNetError = false;
        // 对API调用了observeOn(MainThread)之后，线程会跑在主线程上，包括onComplete也是，
        // unsubscribe也在主线程，然后如果这时候调用call.cancel会导致NetworkOnMainThreadException
        // 加一句unsubscribeOn(io)
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO).getNewsListObservable(type, id, startPage)
                .flatMap(new Func1<NewsSummaryRetrieve, Observable<NewsSummary>>() {
                    @Override
                    public Observable<NewsSummary> call(NewsSummaryRetrieve map) {
                        return Observable.from(map.getList());
                    }
                })
                .map(new Func1<NewsSummary, NewsSummary>() {
                    @Override
                    public NewsSummary call(NewsSummary newsSummary) {
                        String ptime = MyUtils.formatDate(newsSummary.getNews_Time());
                        newsSummary.setNews_Time(ptime);
                        return newsSummary;
                    }
                })
//                .toList()
                .distinct()
                .toSortedList(new Func2<NewsSummary, NewsSummary, Integer>() {
                    @Override
                    public Integer call(NewsSummary newsSummary, NewsSummary newsSummary2) {
                        return newsSummary2.getNews_Time().compareTo(newsSummary.getNews_Time());
                    }
                })
                .compose(TransformUtils.<List<NewsSummary>>defaultSchedulers())
                .subscribe(new Subscriber<List<NewsSummary>>() {
                    @Override
                    public void onCompleted() {
                        KLog.d();
//                        checkNetState(listener);
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.toString());
//                        checkNetState(listener);
//                        if (!NetUtil.isNetworkAvailable(App.getAppContext())) {
                        listener.onError(MyUtils.analyzeNetworkError(e));
//                        }
                    }

                    @Override
                    public void onNext(List<NewsSummary> newsSummaries) {
                        KLog.d();
                        List<NewsSummary> filtered = new RecommandationFilter().filterFrom(new KeywordFilter().filterFrom(newsSummaries));
                        listener.success(filtered);
                    }
                });

    }

//    private void checkNetState(RequestCallBack<List<NewsSummary>> listener) {
//        if (!NetUtil.isNetworkAvailable(App.getAppContext())) {
//            mIsNetError = true;
//            listener.onError(App.getAppContext().getString(R.string.internet_error));
//        } else {
//            mIsNetError = false;
//        }
//    }
}
