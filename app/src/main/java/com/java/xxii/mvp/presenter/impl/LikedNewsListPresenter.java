/*

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

import com.java.xxii.greendao.LikeNews;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.common.LoadNewsType;
import com.java.xxii.mvp.interactor.NewsListInteractor;
import com.java.xxii.mvp.interactor.impl.LikedNewsListInteractor;
import com.java.xxii.mvp.interactor.impl.NewsListInteractorImpl;
import com.java.xxii.listener.RequestCallBack;
import com.java.xxii.mvp.presenter.NewsListPresenter;
import com.java.xxii.mvp.presenter.base.BasePresenterImpl;
import com.java.xxii.mvp.view.LikedNewsListView;
import com.java.xxii.mvp.view.NewsListView;

import java.util.List;

import javax.inject.Inject;


public class LikedNewsListPresenter extends BasePresenterImpl<LikedNewsListView, List<LikeNews>>
        implements  RequestCallBack<List<LikeNews>> {

    private LikedNewsListInteractor mNewsListInteractor;
    private boolean misFirstLoad;
    private boolean mIsRefresh = true;

    @Inject
    public LikedNewsListPresenter(LikedNewsListInteractor newsListInteractor) {
        mNewsListInteractor = newsListInteractor;
    }

    @Override
    public void onCreate() {

        //added line mStartPage = 1
        if (mView != null) {
            loadNewsData();
        }
    }

    @Override
    public void beforeRequest() {
        if (!misFirstLoad) {
            mView.showProgress();
        }
    }

    @Override
    public void onError(String errorMsg) {
        super.onError(errorMsg);
        if (mView != null) {
            int loadType = mIsRefresh ? LoadNewsType.TYPE_REFRESH_ERROR : LoadNewsType.TYPE_LOAD_MORE_ERROR;
            mView.setNewsList(null, loadType);
        }
    }

    public void success(List<LikeNews> items) {
        misFirstLoad = true;
        int loadType = mIsRefresh ? LoadNewsType.TYPE_REFRESH_SUCCESS : LoadNewsType.TYPE_LOAD_MORE_SUCCESS;
        if (mView != null) {
            mView.setNewsList(items, loadType);
            mView.hideProgress();
        }

    }
    public void refreshData() {
        mIsRefresh = true;
        loadNewsData();
    }


    private void loadNewsData() {
        mSubscription = mNewsListInteractor.loadNews(this);
    }
}
