package com.java.xxii.mvp.interactor.impl;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public enum PhotoDetailInteractorImpl_Factory implements Factory<PhotoDetailInteractorImpl> {
  INSTANCE;

  @Override
  public PhotoDetailInteractorImpl get() {
    return new PhotoDetailInteractorImpl();
  }

  public static Factory<PhotoDetailInteractorImpl> create() {
    return INSTANCE;
  }
}
