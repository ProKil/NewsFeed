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
import com.java.xxii.R;
import com.java.xxii.common.HostType;
import com.java.xxii.greendao.LikeNews;
import com.java.xxii.greendao.LikeNewsDao;
import com.java.xxii.greendao.NewsChannelTable;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.mvp.entity.NewsSummaryRetrieve;
import com.java.xxii.mvp.interactor.NewsInteractor;
import com.java.xxii.repository.db.NewsChannelTableManager;
import com.java.xxii.repository.network.RetrofitManager;
import com.java.xxii.utils.MyUtils;
import com.java.xxii.utils.TransformUtils;
import com.socks.library.KLog;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.functions.Func2;

public class LikedNewsListInteractor{

    @Inject
    public LikedNewsListInteractor() {
    }

    public Subscription loadNews(final RequestCallBack<List<LikeNews>> listener) {

        return Observable.create(new Observable.OnSubscribe<List<LikeNews>>(){
            @Override
            public void call(Subscriber<? super List<LikeNews>> subscriber) {
                LikeNewsDao dao = App.getLikeNewsDao();
                subscriber.onNext(dao.loadAll());
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<List<LikeNews>>() {
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
                    public void onNext(List<LikeNews> newsSummaries) {
                        KLog.d();
                        Collections.reverse(newsSummaries);
                        listener.success(newsSummaries);
                    }
                });
    }
}
