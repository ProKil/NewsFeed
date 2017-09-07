package com.java.xxii.mvp.ui.activities;

import com.java.xxii.mvp.presenter.impl.NewsDetailPresenterImpl;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsDetailActivity_MembersInjector
    implements MembersInjector<NewsDetailActivity> {
  private final Provider<NewsDetailPresenterImpl> mNewsDetailPresenterProvider;

  public NewsDetailActivity_MembersInjector(
      Provider<NewsDetailPresenterImpl> mNewsDetailPresenterProvider) {
    assert mNewsDetailPresenterProvider != null;
    this.mNewsDetailPresenterProvider = mNewsDetailPresenterProvider;
  }

  public static MembersInjector<NewsDetailActivity> create(
      Provider<NewsDetailPresenterImpl> mNewsDetailPresenterProvider) {
    return new NewsDetailActivity_MembersInjector(mNewsDetailPresenterProvider);
  }

  @Override
  public void injectMembers(NewsDetailActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNewsDetailPresenter = mNewsDetailPresenterProvider.get();
  }

  public static void injectMNewsDetailPresenter(
      NewsDetailActivity instance, Provider<NewsDetailPresenterImpl> mNewsDetailPresenterProvider) {
    instance.mNewsDetailPresenter = mNewsDetailPresenterProvider.get();
  }
}
