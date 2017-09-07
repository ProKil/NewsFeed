package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.interactor.impl.NewsListInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsListPresenterImpl_Factory implements Factory<NewsListPresenterImpl> {
  private final MembersInjector<NewsListPresenterImpl> newsListPresenterImplMembersInjector;

  private final Provider<NewsListInteractorImpl> newsListInteractorProvider;

  public NewsListPresenterImpl_Factory(
      MembersInjector<NewsListPresenterImpl> newsListPresenterImplMembersInjector,
      Provider<NewsListInteractorImpl> newsListInteractorProvider) {
    assert newsListPresenterImplMembersInjector != null;
    this.newsListPresenterImplMembersInjector = newsListPresenterImplMembersInjector;
    assert newsListInteractorProvider != null;
    this.newsListInteractorProvider = newsListInteractorProvider;
  }

  @Override
  public NewsListPresenterImpl get() {
    return MembersInjectors.injectMembers(
        newsListPresenterImplMembersInjector,
        new NewsListPresenterImpl(newsListInteractorProvider.get()));
  }

  public static Factory<NewsListPresenterImpl> create(
      MembersInjector<NewsListPresenterImpl> newsListPresenterImplMembersInjector,
      Provider<NewsListInteractorImpl> newsListInteractorProvider) {
    return new NewsListPresenterImpl_Factory(
        newsListPresenterImplMembersInjector, newsListInteractorProvider);
  }
}
