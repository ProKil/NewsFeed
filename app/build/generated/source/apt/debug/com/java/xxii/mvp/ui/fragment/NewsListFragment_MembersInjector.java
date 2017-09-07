package com.java.xxii.mvp.ui.fragment;

import android.app.Activity;
import com.java.xxii.mvp.presenter.impl.NewsListPresenterImpl;
import com.java.xxii.mvp.ui.adapter.NewsListAdapter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsListFragment_MembersInjector implements MembersInjector<NewsListFragment> {
  private final Provider<NewsListAdapter> mNewsListAdapterProvider;

  private final Provider<NewsListPresenterImpl> mNewsListPresenterProvider;

  private final Provider<Activity> mActivityProvider;

  public NewsListFragment_MembersInjector(
      Provider<NewsListAdapter> mNewsListAdapterProvider,
      Provider<NewsListPresenterImpl> mNewsListPresenterProvider,
      Provider<Activity> mActivityProvider) {
    assert mNewsListAdapterProvider != null;
    this.mNewsListAdapterProvider = mNewsListAdapterProvider;
    assert mNewsListPresenterProvider != null;
    this.mNewsListPresenterProvider = mNewsListPresenterProvider;
    assert mActivityProvider != null;
    this.mActivityProvider = mActivityProvider;
  }

  public static MembersInjector<NewsListFragment> create(
      Provider<NewsListAdapter> mNewsListAdapterProvider,
      Provider<NewsListPresenterImpl> mNewsListPresenterProvider,
      Provider<Activity> mActivityProvider) {
    return new NewsListFragment_MembersInjector(
        mNewsListAdapterProvider, mNewsListPresenterProvider, mActivityProvider);
  }

  @Override
  public void injectMembers(NewsListFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNewsListAdapter = mNewsListAdapterProvider.get();
    instance.mNewsListPresenter = mNewsListPresenterProvider.get();
    instance.mActivity = mActivityProvider.get();
  }

  public static void injectMNewsListAdapter(
      NewsListFragment instance, Provider<NewsListAdapter> mNewsListAdapterProvider) {
    instance.mNewsListAdapter = mNewsListAdapterProvider.get();
  }

  public static void injectMNewsListPresenter(
      NewsListFragment instance, Provider<NewsListPresenterImpl> mNewsListPresenterProvider) {
    instance.mNewsListPresenter = mNewsListPresenterProvider.get();
  }

  public static void injectMActivity(
      NewsListFragment instance, Provider<Activity> mActivityProvider) {
    instance.mActivity = mActivityProvider.get();
  }
}
