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
import com.java.xxii.greendao.NewsChannelTable;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.interactor.NewsInteractor;
import com.java.xxii.repository.db.NewsChannelTableManager;
import com.java.xxii.utils.TransformUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author 咖枯
 * @version 1.0 2016/6/2
 */
public class NewsInteractorImpl implements NewsInteractor<List<NewsChannelTable>> {

    @Inject
    public NewsInteractorImpl() {
    }

    @Override
    public Subscription lodeNewsChannels(final RequestCallBack<List<NewsChannelTable>> callback) {
        return Observable.create(new Observable.OnSubscribe<List<NewsChannelTable>>() {
            @Override
            public void call(Subscriber<? super List<NewsChannelTable>> subscriber) {
                NewsChannelTableManager.initDB();
                subscriber.onNext(NewsChannelTableManager.loadNewsChannelsMine());
                subscriber.onCompleted();
            }
        })
                .compose(TransformUtils.<List<NewsChannelTable>>defaultSchedulers())
                .subscribe(new Subscriber<List<NewsChannelTable>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(App.getAppContext().getString(R.string.db_error));
                    }

                    @Override
                    public void onNext(List<NewsChannelTable> newsChannelTables) {
                        callback.success(newsChannelTables);
                    }
                });
    }
}
