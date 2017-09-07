package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum NewsListInteractorImpl_Factory implements Factory<NewsListInteractorImpl> {
  INSTANCE;

  @Override
  public NewsListInteractorImpl get() {
    return new NewsListInteractorImpl();
  }

  public static Factory<NewsListInteractorImpl> create() {
    return INSTANCE;
  }
}
