package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum NewsDetailInteractorImpl_Factory implements Factory<NewsDetailInteractorImpl> {
  INSTANCE;

  @Override
  public NewsDetailInteractorImpl get() {
    return new NewsDetailInteractorImpl();
  }

  public static Factory<NewsDetailInteractorImpl> create() {
    return INSTANCE;
  }
}
