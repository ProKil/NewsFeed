package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum PhotoInteractorImpl_Factory implements Factory<PhotoInteractorImpl> {
  INSTANCE;

  @Override
  public PhotoInteractorImpl get() {
    return new PhotoInteractorImpl();
  }

  public static Factory<PhotoInteractorImpl> create() {
    return INSTANCE;
  }
}
