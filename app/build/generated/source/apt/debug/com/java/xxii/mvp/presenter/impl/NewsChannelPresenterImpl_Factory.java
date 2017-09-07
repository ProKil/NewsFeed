package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.interactor.impl.NewsChannelInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsChannelPresenterImpl_Factory implements Factory<NewsChannelPresenterImpl> {
  private final MembersInjector<NewsChannelPresenterImpl> newsChannelPresenterImplMembersInjector;

  private final Provider<NewsChannelInteractorImpl> newsChannelInteractorProvider;

  public NewsChannelPresenterImpl_Factory(
      MembersInjector<NewsChannelPresenterImpl> newsChannelPresenterImplMembersInjector,
      Provider<NewsChannelInteractorImpl> newsChannelInteractorProvider) {
    assert newsChannelPresenterImplMembersInjector != null;
    this.newsChannelPresenterImplMembersInjector = newsChannelPresenterImplMembersInjector;
    assert newsChannelInteractorProvider != null;
    this.newsChannelInteractorProvider = newsChannelInteractorProvider;
  }

  @Override
  public NewsChannelPresenterImpl get() {
    return MembersInjectors.injectMembers(
        newsChannelPresenterImplMembersInjector,
        new NewsChannelPresenterImpl(newsChannelInteractorProvider.get()));
  }

  public static Factory<NewsChannelPresenterImpl> create(
      MembersInjector<NewsChannelPresenterImpl> newsChannelPresenterImplMembersInjector,
      Provider<NewsChannelInteractorImpl> newsChannelInteractorProvider) {
    return new NewsChannelPresenterImpl_Factory(
        newsChannelPresenterImplMembersInjector, newsChannelInteractorProvider);
  }
}
