package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum NewsInteractorImpl_Factory implements Factory<NewsInteractorImpl> {
  INSTANCE;

  @Override
  public NewsInteractorImpl get() {
    return new NewsInteractorImpl();
  }

  public static Factory<NewsInteractorImpl> create() {
    return INSTANCE;
  }
}
