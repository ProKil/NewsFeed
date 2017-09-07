package com.java.xxii.mvp.presenter.impl;

import com.java.xxii.mvp.interactor.impl.NewsInteractorImpl;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewPresenterImpl_Factory implements Factory<NewPresenterImpl> {
  private final MembersInjector<NewPresenterImpl> newPresenterImplMembersInjector;

  private final Provider<NewsInteractorImpl> newsInteractorProvider;

  public NewPresenterImpl_Factory(
      MembersInjector<NewPresenterImpl> newPresenterImplMembersInjector,
      Provider<NewsInteractorImpl> newsInteractorProvider) {
    assert newPresenterImplMembersInjector != null;
    this.newPresenterImplMembersInjector = newPresenterImplMembersInjector;
    assert newsInteractorProvider != null;
    this.newsInteractorProvider = newsInteractorProvider;
  }

  @Override
  public NewPresenterImpl get() {
    return MembersInjectors.injectMembers(
        newPresenterImplMembersInjector, new NewPresenterImpl(newsInteractorProvider.get()));
  }

  public static Factory<NewPresenterImpl> create(
      MembersInjector<NewPresenterImpl> newPresenterImplMembersInjector,
      Provider<NewsInteractorImpl> newsInteractorProvider) {
    return new NewPresenterImpl_Factory(newPresenterImplMembersInjector, newsInteractorProvider);
  }
}
