package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.interactor.impl.NewsDetailInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsDetailPresenterImpl_Factory implements Factory<NewsDetailPresenterImpl> {
  private final MembersInjector<NewsDetailPresenterImpl> newsDetailPresenterImplMembersInjector;

  private final Provider<NewsDetailInteractorImpl> newsDetailInteractorProvider;

  public NewsDetailPresenterImpl_Factory(
      MembersInjector<NewsDetailPresenterImpl> newsDetailPresenterImplMembersInjector,
      Provider<NewsDetailInteractorImpl> newsDetailInteractorProvider) {
    assert newsDetailPresenterImplMembersInjector != null;
    this.newsDetailPresenterImplMembersInjector = newsDetailPresenterImplMembersInjector;
    assert newsDetailInteractorProvider != null;
    this.newsDetailInteractorProvider = newsDetailInteractorProvider;
  }

  @Override
  public NewsDetailPresenterImpl get() {
    return MembersInjectors.injectMembers(
        newsDetailPresenterImplMembersInjector,
        new NewsDetailPresenterImpl(newsDetailInteractorProvider.get()));
  }

  public static Factory<NewsDetailPresenterImpl> create(
      MembersInjector<NewsDetailPresenterImpl> newsDetailPresenterImplMembersInjector,
      Provider<NewsDetailInteractorImpl> newsDetailInteractorProvider) {
    return new NewsDetailPresenterImpl_Factory(
        newsDetailPresenterImplMembersInjector, newsDetailInteractorProvider);
  }
}
