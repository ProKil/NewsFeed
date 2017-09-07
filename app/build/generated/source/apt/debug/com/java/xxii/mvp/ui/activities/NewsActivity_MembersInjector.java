package com.java.xxii.mvp.ui.activities;

import com.java.xxii.mvp.presenter.impl.NewPresenterImpl;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsActivity_MembersInjector implements MembersInjector<NewsActivity> {
  private final Provider<NewPresenterImpl> mNewsPresenterProvider;

  public NewsActivity_MembersInjector(Provider<NewPresenterImpl> mNewsPresenterProvider) {
    assert mNewsPresenterProvider != null;
    this.mNewsPresenterProvider = mNewsPresenterProvider;
  }

  public static MembersInjector<NewsActivity> create(
      Provider<NewPresenterImpl> mNewsPresenterProvider) {
    return new NewsActivity_MembersInjector(mNewsPresenterProvider);
  }

  @Override
  public void injectMembers(NewsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNewsPresenter = mNewsPresenterProvider.get();
  }

  public static void injectMNewsPresenter(
      NewsActivity instance, Provider<NewPresenterImpl> mNewsPresenterProvider) {
    instance.mNewsPresenter = mNewsPresenterProvider.get();
  }
}
