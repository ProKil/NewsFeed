package com.java.xxii.mvp.ui.adapter;

import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NewsListAdapter_Factory implements Factory<NewsListAdapter> {
  private final MembersInjector<NewsListAdapter> newsListAdapterMembersInjector;

  public NewsListAdapter_Factory(MembersInjector<NewsListAdapter> newsListAdapterMembersInjector) {
    assert newsListAdapterMembersInjector != null;
    this.newsListAdapterMembersInjector = newsListAdapterMembersInjector;
  }

  @Override
  public NewsListAdapter get() {
    return MembersInjectors.injectMembers(newsListAdapterMembersInjector, new NewsListAdapter());
  }

  public static Factory<NewsListAdapter> create(
      MembersInjector<NewsListAdapter> newsListAdapterMembersInjector) {
    return new NewsListAdapter_Factory(newsListAdapterMembersInjector);
  }
}
