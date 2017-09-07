package com.java.xxii.mvp.ui.activities;

import com.java.xxii.mvp.presenter.impl.NewsChannelPresenterImpl;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsChannelActivity_MembersInjector
    implements MembersInjector<NewsChannelActivity> {
  private final Provider<NewsChannelPresenterImpl> mNewsChannelPresenterProvider;

  public NewsChannelActivity_MembersInjector(
      Provider<NewsChannelPresenterImpl> mNewsChannelPresenterProvider) {
    assert mNewsChannelPresenterProvider != null;
    this.mNewsChannelPresenterProvider = mNewsChannelPresenterProvider;
  }

  public static MembersInjector<NewsChannelActivity> create(
      Provider<NewsChannelPresenterImpl> mNewsChannelPresenterProvider) {
    return new NewsChannelActivity_MembersInjector(mNewsChannelPresenterProvider);
  }

  @Override
  public void injectMembers(NewsChannelActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.mNewsChannelPresenter = mNewsChannelPresenterProvider.get();
  }

  public static void injectMNewsChannelPresenter(
      NewsChannelActivity instance,
      Provider<NewsChannelPresenterImpl> mNewsChannelPresenterProvider) {
    instance.mNewsChannelPresenter = mNewsChannelPresenterProvider.get();
  }
}
