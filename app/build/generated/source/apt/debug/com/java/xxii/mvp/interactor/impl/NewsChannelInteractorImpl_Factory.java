package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum NewsChannelInteractorImpl_Factory implements Factory<NewsChannelInteractorImpl> {
  INSTANCE;

  @Override
  public NewsChannelInteractorImpl get() {
    return new NewsChannelInteractorImpl();
  }

  public static Factory<NewsChannelInteractorImpl> create() {
    return INSTANCE;
  }
}
