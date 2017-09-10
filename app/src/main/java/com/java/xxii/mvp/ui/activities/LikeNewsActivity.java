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
package com.java.xxii.mvp.ui.activities;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.java.xxii.R;
import com.java.xxii.annotation.BindValues;
import com.java.xxii.common.Constants;
import com.java.xxii.common.LoadNewsType;
import com.java.xxii.event.ChannelChangeEvent;
import com.java.xxii.event.ScrollToTopEvent;
import com.java.xxii.greendao.LikeNewsDao;
import com.java.xxii.greendao.LikeNews;
import com.java.xxii.greendao.NewsChannelTable;
import com.java.xxii.mvp.entity.NewsPhotoDetail;
import com.java.xxii.mvp.entity.NewsSummary;
import com.java.xxii.mvp.presenter.impl.LikedNewsListPresenter;
import com.java.xxii.mvp.presenter.impl.NewsListPresenterImpl;
import com.java.xxii.mvp.ui.activities.base.BaseActivity;
import com.java.xxii.mvp.ui.adapter.LikeNewsListAdapter;
import com.java.xxii.mvp.ui.adapter.NewsListAdapter;
import com.java.xxii.mvp.ui.adapter.PagerAdapter.NewsFragmentPagerAdapter;
import com.java.xxii.mvp.ui.fragment.NewsListFragment;
import com.java.xxii.mvp.view.LikedNewsListView;
import com.java.xxii.mvp.view.NewsView;
import com.java.xxii.utils.MyUtils;
import com.java.xxii.utils.NetUtil;
import com.java.xxii.utils.RxBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

@BindValues(mIsHasNavigationView = true)
public class LikeNewsActivity extends BaseActivity implements LikedNewsListView,LikeNewsListAdapter.OnNewsListItemClickListener,
        SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.news_rv)
    RecyclerView mNewsRV;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.empty_view)
    TextView mEmptyView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Inject
    LikeNewsListAdapter mNewsListAdapter;
    @Inject
    LikedNewsListPresenter mNewsListPresenter;

    private boolean mIsAllLoaded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }
    @Override
    public void onItemClick(View view, int position) {
        goToNewsDetailActivity(view, position);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_like_news;
    }

    @Override
    public void initInjector() {
        mActivityComponent.inject(this);
    }

    @Override
    public void initViews() {
        mBaseNavView = mNavView;
        mPresenter = mNewsListPresenter;
        mPresenter.attachView(this);
        initSwipeRefreshLayout();
        initRecyclerView();
    }
    private void goToNewsDetailActivity(View view, int position) {
        Intent intent = setIntent(position);
        startActivity(view, intent);
    }
    private void startActivity(View view, Intent intent) {
        ImageView newsSummaryPhotoIv = (ImageView) view.findViewById(R.id.news_summary_photo_iv);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions
                    .makeSceneTransitionAnimation(this, newsSummaryPhotoIv, Constants.TRANSITION_ANIMATION_NEWS_PHOTOS);
            startActivity(intent, options.toBundle());
        } else {
            ActivityOptionsCompat options = ActivityOptionsCompat
                    .makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
            ActivityCompat.startActivity(this, intent, options.toBundle());
        }
    }
    private void initSwipeRefreshLayout() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeColors(this.getResources().getIntArray(R.array.gplus_colors)
        );
    }
    private void initRecyclerView() {
        mNewsRV.setHasFixedSize(true);
        mNewsRV.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        mNewsRV.setItemAnimator(new DefaultItemAnimator());
        mNewsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                int lastVisibleItemPosition = ((LinearLayoutManager) layoutManager)
                        .findLastVisibleItemPosition();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();

                if (!mIsAllLoaded && visibleItemCount > 0 && newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition >= totalItemCount - 1) {

                    mNewsListAdapter.showFooter();
                    mNewsRV.scrollToPosition(mNewsListAdapter.getItemCount() - 1);
                }
            }

        });
        mNewsListAdapter.setOnItemClickListener(this);
        mNewsRV.setAdapter(mNewsListAdapter);
    }
    @Override
    public void onRefresh() {
        mNewsListPresenter.refreshData();
    }
    @Override
    public void setNewsList(List<LikeNews> newsSummary, @LoadNewsType.checker int loadType) {
        if(newsSummary.size() == 0){
            Toast.makeText(getApplicationContext(),"暂无收藏", Toast.LENGTH_SHORT).show();
            mProgressBar.setVisibility(View.GONE);
        }
        switch (loadType) {
            case LoadNewsType.TYPE_REFRESH_SUCCESS:
                mSwipeRefreshLayout.setRefreshing(false);
                mNewsListAdapter.setList(newsSummary);
                mNewsListAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
                //checkIsEmpty(newsSummary);
                break;
            case LoadNewsType.TYPE_REFRESH_ERROR:
                mSwipeRefreshLayout.setRefreshing(false);
               // checkIsEmpty(newsSummary);
                break;
            case LoadNewsType.TYPE_LOAD_MORE_SUCCESS:
                mNewsListAdapter.hideFooter();
                if (newsSummary == null || newsSummary.size() == 0) {
                    mIsAllLoaded = true;
                    Snackbar.make(mNewsRV, getString(R.string.no_more), Snackbar.LENGTH_SHORT).show();
                } else {
                    //mNewsListAdapter.addMore(newsSummary);
                }
                break;
            case LoadNewsType.TYPE_LOAD_MORE_ERROR:
                mNewsListAdapter.hideFooter();
                break;
        }
    }

    public Integer getNewsListLength(){
        return mNewsListAdapter.getList().size();
    }

    private void checkIsEmpty(List<LikeNews> newsSummary) {
        if (newsSummary == null && mNewsListAdapter.getList() == null) {
            mNewsRV.setVisibility(View.GONE);
            mEmptyView.setVisibility(View.VISIBLE);

        } else {
            mNewsRV.setVisibility(View.VISIBLE);
            mEmptyView.setVisibility(View.GONE);
        }
    }
    @NonNull
    private Intent setIntent(int position) {
        List<LikeNews> newsSummaryList = mNewsListAdapter.getList();

        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra(Constants.NEWS_POST_ID, newsSummaryList.get(position).getNews_Id());
        intent.putExtra(Constants.NEWS_IMG_RES, newsSummaryList.get(position).getNews_Img());
        return intent;
    }
    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
    public void showMsg(String message) {
        mProgressBar.setVisibility(View.GONE);
        // 网络不可用状态在此之前已经显示了提示信息
        if (NetUtil.isNetworkAvailable()) {
            Snackbar.make(mNewsRV, message, Snackbar.LENGTH_LONG).show();
        }
    }

}



