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
package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.entity.NewsDetail;
import com.java.xxii.mvp.interactor.NewsDetailInteractor;
import com.java.xxii.mvp.interactor.impl.NewsDetailInteractorImpl;
import com.java.xxii.mvp.presenter.NewsDetailPresenter;
import com.java.xxii.mvp.presenter.base.BasePresenterImpl;
import com.java.xxii.mvp.view.NewsDetailView;

import javax.inject.Inject;

/**
 * @author 咖枯
 * @version 1.0 2016/6/5
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<NewsDetailView, NewsDetail>
        implements NewsDetailPresenter {
    private NewsDetailInteractor<NewsDetail> mNewsDetailInteractor;
    private String mPostId;

    @Inject
    public NewsDetailPresenterImpl(NewsDetailInteractorImpl newsDetailInteractor) {
        mNewsDetailInteractor = newsDetailInteractor;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSubscription = mNewsDetailInteractor.loadNewsDetail(this, mPostId);

    }

    @Override
    public void success(NewsDetail data) {
        super.success(data);
        mView.setNewsDetail(data);
    }

    @Override
    public void setPosId(String postId) {
        mPostId = postId;
    }
}
